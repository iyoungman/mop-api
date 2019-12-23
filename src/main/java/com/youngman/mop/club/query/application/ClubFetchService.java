package com.youngman.mop.club.query.application;

import com.youngman.mop.club.command.dto.ClubInfoResponse;
import com.youngman.mop.club.command.dto.ClubResponse;
import com.youngman.mop.club.query.ClubMapper;
import com.youngman.mop.club.query.dto.ClubCacheKey;
import com.youngman.mop.club.command.dto.ClubPagingResponse;
import com.youngman.mop.club.command.domain.Club;
import com.youngman.mop.club.command.domain.ClubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.Cacheable;
import java.util.Optional;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubFetchService {

    private final ClubRepository clubRepository;
//    private final MemberFindDao memberFindDao;
//    private final ClubCache clubCache;
    private final ClubMapper clubMapper;


    public ClubPagingResponse selectPagingClubsByMember(String email, PageRequest pageable) {
        Page<ClubResponse> pagingClubResponse = clubRepository.selectPagingClubsByMember(
                email, memberFindDao.findAddressByEmail(email), pageable);

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
