package com.youngman.mop.domain.club.application;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.domain.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-12-23.
 */

@Service
@RequiredArgsConstructor
public class ClubRegisterService {

	public final ClubRepository clubRepository;

	public void registerClub(Long clubId, Long memberId) {
		Club club = clubRepository.findById(clubId).get();
		club.registerClub(memberId);
	}
}
