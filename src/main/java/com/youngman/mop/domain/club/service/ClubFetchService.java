package com.youngman.mop.domain.club.service;

import com.youngman.mop.domain.club.dao.ClubRepository;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.domain.ClubCacheKey;
import com.youngman.mop.domain.club.dto.ClubInfoResponse;
import com.youngman.mop.domain.club.dto.ClubPagingResponse;
import com.youngman.mop.domain.club.dto.ClubResponse;
import com.youngman.mop.domain.member.dao.MemberFindDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubFetchService {

    private final ClubRepository clubRepository;
    private final MemberFindDao memberFindDao;
    private final ClubCache clubCache;
    private final ClubMapper clubMapper;

    public ClubPagingResponse fetchPagingClubsByMember(String email, PageRequest pageable) {
        Page<ClubResponse> pagingClubResponse = clubRepository.fetchPagingClubsByMember(
                email, memberFindDao.findAddressByEmail(email), pageable);

        return ClubPagingResponse.of(pagingClubResponse);
    }

    @Cacheable(value = ClubCacheKey.CLUB_INFO, key = "#clubId", unless = "#result == null")
    public ClubInfoResponse fetchClubInfoById(Long clubId) {
        Optional<Club> club = clubRepository.fetchClubInfoById(clubId);
        if (club.isPresent()) {
            return clubMapper.mapFrom(club.get());
        }
        return new ClubInfoResponse();
    }

//    private ClubInfoResponse fromRepository(Long clubId) {
//        Optional<Club> club = clubRepository.fetchClubInfoById(clubId);
//        if (club.isPresent()) {
//            ClubInfoResponse clubInfoResponse = clubMapper.mapFrom(club.get());
//            clubCache.toCache(clubId, clubInfoResponse);
//            return clubInfoResponse;
//        }
//        return new ClubInfoResponse();
//    }

}
