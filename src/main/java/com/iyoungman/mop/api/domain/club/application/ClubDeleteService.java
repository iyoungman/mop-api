package com.iyoungman.mop.api.domain.club.application;

import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.club.domain.ClubRepository;
import com.iyoungman.mop.api.domain.club.exception.ClubNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@Transactional
@RequiredArgsConstructor
public class ClubDeleteService {

    private final ClubRepository clubRepository;

    public void deleteClub(Long clubId, Long memberId) {
        Club club = clubRepository.findById(clubId).orElseThrow(ClubNotFoundException::new);
        club.verifyChairMan(memberId);
        clubRepository.deleteById(clubId);
    }
}
