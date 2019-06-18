package com.youngman.mop.domain.club.repository;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.exception.ClubNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-06-17.
 */

@Service
@RequiredArgsConstructor
public class ClubFindDao {

	private final ClubRepository clubRepository;


	public Club findById(Long clubId) {
		return clubRepository.findById(clubId)
				.orElseThrow(ClubNotFoundException::new)
		;
	}
}
