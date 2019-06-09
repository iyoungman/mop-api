package com.youngman.mop.service.club;

import com.youngman.mop.domain.entity.Club;
import com.youngman.mop.domain.dto.ClubCreateRequestDto;
import com.youngman.mop.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubCreateService {

	private final ClubRepository clubRepository;

	public void createClub(ClubCreateRequestDto clubCreateRequestDto) {
		clubRepository.save(Club.of(clubCreateRequestDto));
	}
}
