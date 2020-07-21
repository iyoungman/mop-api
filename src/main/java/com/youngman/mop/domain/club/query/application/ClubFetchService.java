package com.youngman.mop.domain.club.query.application;

import com.youngman.mop.domain.club.api.dto.ClubInfoResponse;
import com.youngman.mop.domain.club.api.dto.ClubPagingResponse;
import com.youngman.mop.domain.club.api.dto.ClubResponse;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.domain.ClubRepository;
import com.youngman.mop.domain.club.query.ClubCache;
import com.youngman.mop.domain.club.query.dto.ClubCacheKey;
import com.youngman.mop.domain.member.domain.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
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
    private final ClubCache clubCache;
//    private final ClubMapper clubMapper;

    public ClubPagingResponse selectPagingClubsByMember(String email, PageRequest pageable) {
//        Page<ClubResponse> pagingClubResponse = clubRepository.selectPagingClubsByMember(
//                email, memberRepository.findAddressByEmail(email).getAddress().toString(), pageable);
//
//        return ClubPagingResponse.of(pagingClubResponse);
        return null;
    }

    @Cacheable(value = ClubCacheKey.CLUB_INFO, key = "#clubId", unless = "#result == null")
    public ClubInfoResponse selectClubInfoById(Long clubId) {
//        ClubInfoResponse clubInfoResponse = clubCache.fromCache(clubId);
//        return clubInfoResponse != null ? clubInfoResponse : fromRepository(clubId);
        return null;
    }

    private ClubInfoResponse fromRepository(Long clubId) {
        Optional<Club> club = clubRepository.selectClubInfoById(clubId);
//        if (club.isPresent()) {
//            ClubInfoResponse clubInfoResponse = clubMapper.mapFrom(club.get());
//            clubCache.toCache(clubId, clubInfoResponse);
//            return clubInfoResponse;
//        }
        return new ClubInfoResponse();
    }

}
