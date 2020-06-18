package com.youngman.mop.domain.club.application;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.domain.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubDeleteService {

    private final ClubRepository clubRepository;

    @Transactional
    public void deleteClub(Long clubId, Long memberId) {
        Club club = clubRepository.findById(clubId).get();
        club.verifyChairMan(memberId);
        clubRepository.deleteById(clubId);
    }
}
