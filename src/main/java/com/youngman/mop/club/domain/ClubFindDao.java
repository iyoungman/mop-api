package com.youngman.mop.club.domain;

import com.youngman.mop.club.exception.ClubNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by YoungMan on 2019-06-17.
 */

@Service
@RequiredArgsConstructor
public class ClubFindDao {

    private final ClubRepository clubRepository;


    public Club findById(Long clubId) {
        Optional<Club> club = clubRepository.findById(clubId);
        club.orElseThrow(ClubNotFoundException::new);
        return club.get();
    }

    public boolean isClubChair(Long clubId, String email) {
        Optional<Club> club = clubRepository.findById(clubId);
        club.orElseThrow(ClubNotFoundException::new);
        return club.get().getChairEmail().equals(email);
    }
}
