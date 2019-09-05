package com.youngman.mop.club.service;

import com.youngman.mop.club.domain.Club;
import com.youngman.mop.club.controller.ClubCreateRequest;
import com.youngman.mop.club.domain.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubCreateService {

    private final ClubRepository clubRepository;


    public void createClub(ClubCreateRequest clubCreateRequest) {
        Club createClub = clubCreateRequest.toEntity();
        clubRepository.save(createClub);
    }
}
