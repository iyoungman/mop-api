package com.iyoungman.mop.api.domain.club.application;

import com.iyoungman.mop.api.domain.club.api.request.ClubCreateRequest;
import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.club.domain.ClubRepository;
import com.iyoungman.mop.api.domain.club.domain.ClubValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@Transactional
@RequiredArgsConstructor
public class ClubCreateService {

    private final ClubRepository clubRepository;

    private final ClubValidator clubValidator;

    public Long createClub(ClubCreateRequest clubCreateRequest) {
        Club createClub = clubCreateRequest.toEntity();
        createClub.validate(clubValidator);

        return clubRepository.save(createClub).getId();
    }
}
