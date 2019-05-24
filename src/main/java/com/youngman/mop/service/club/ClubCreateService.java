package com.youngman.mop.service.club;

import com.youngman.mop.model.domain.Club;
import com.youngman.mop.model.dto.ClubCreateRequestDto;
import com.youngman.mop.repository.ClubRepository;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
public class ClubCreateService {

	private final ClubRepository clubRepository;

	public ClubCreateService(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	public void createClub(ClubCreateRequestDto clubCreateRequestDto) {
		clubRepository.save(Club.of(clubCreateRequestDto));
	}
}
