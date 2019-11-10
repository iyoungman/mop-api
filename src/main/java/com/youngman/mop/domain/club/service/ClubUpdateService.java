package com.youngman.mop.domain.club.service;

import com.youngman.mop.domain.club.dao.ClubFindDao;
import com.youngman.mop.domain.club.dao.ClubRepository;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.domain.ClubCacheKey;
import com.youngman.mop.domain.club.dto.ClubCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubUpdateService {

    private final ClubRepository clubRepository;
    private final ClubFindDao clubFindDao;
//    private final ClubCache clubCache;

//    @CachePut(value = ClubCacheKey.CLUB_INFO, key = "#clubId")
    public void updateClub(ClubCreateRequest clubCreateRequest) {
        Club club = clubFindDao.findById(clubCreateRequest.getClubId());
        club.updateClub(clubCreateRequest);
        clubRepository.save(club);
    }

}
