package com.youngman.mop.club.service;

import com.youngman.mop.club.domain.ClubFindDao;
import com.youngman.mop.club.domain.ClubRepository;
import com.youngman.mop.club.domain.Club;
import com.youngman.mop.club.controller.ClubCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final ClubCache clubCache;


    public void updateClub(ClubCreateRequest clubCreateRequest) {
        clubCache.delete(clubCreateRequest.getClubId());

        Club club = clubFindDao.findById(clubCreateRequest.getClubId());
        club.updateClub(clubCreateRequest);
        clubRepository.save(club);
    }

}
