package com.youngman.mop.domain.club.service;

import com.youngman.mop.domain.club.dao.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubDeleteService {

    private final ClubRepository clubRepository;
    private final ClubCache clubCache;


    public void deleteClub(Long clubId) {
        clubCache.delete(clubId);
        clubRepository.deleteById(clubId);
    }
}
