package com.youngman.mop.domain.club.query.application;

import com.youngman.mop.domain.club.api.dto.ClubInfoResponse;
import com.youngman.mop.domain.club.api.dto.ClubPagingResponse;
import com.youngman.mop.domain.club.api.dto.ClubResponse;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.domain.ClubRepository;
import com.youngman.mop.domain.club.query.ClubMapper;
import com.youngman.mop.domain.club.query.dto.ClubCacheKey;
import com.youngman.mop.domain.member.domain.MemberRepository;
import com.youngman.mop.domain.member.infra.repository.MemberFindDao;
import java.util.Optional;
import javax.persistence.Cacheable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubFetchService {

    private final ClubRepository clubRepository;
    private final MemberRepository memberRepository;
    private final MemberFindDao memberFindDao;
//    private final ClubCache clubCache;
    private final ClubMapper clubMapper;


    public ClubPagingResponse selectPagingClubsByMember(String email, PageRequest pageable) {
        Page<ClubResponse> pagingClubResponse = clubRepository.selectPagingClubsByMember(
                email, memberRepository.findAddressByEmail(email), pageable);

        return ClubPagingResponse.of(pagingClubResponse);
    }

    @Cacheable(value = ClubCacheKey.CLUB_INFO, key = "#clubId", unless = "#result == null")
    public ClubInfoResponse selectClubInfoById(Long clubId) {
        ClubInfoResponse clubInfoResponse = clubCache.fromCache(clubId);
        return clubInfoResponse != null ? clubInfoResponse : fromRepository(clubId);
    }

    private ClubInfoResponse fromRepository(Long clubId) {
        Optional<Club> club = clubRepository.selectClubInfoById(clubId);
        if (club.isPresent()) {
            ClubInfoResponse clubInfoResponse = clubMapper.mapFrom(club.get());
            clubCache.toCache(clubId, clubInfoResponse);
            return clubInfoResponse;
        }
        return new ClubInfoResponse();
    }

}
