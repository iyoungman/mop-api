package com.youngman.mop.service.club;

import com.youngman.mop.exception.UserDefineException;
import com.youngman.mop.model.domain.Club;
import com.youngman.mop.model.dto.ClubCreateRequestDto;
import com.youngman.mop.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubUpdateService {

	private final ClubRepository clubRepository;

	public void updateClub(ClubCreateRequestDto clubCreateRequestDto) {
		Club club = findById(clubCreateRequestDto.getClubId());
		club.updateClub(clubCreateRequestDto);
		clubRepository.save(club);
	}

	private Club findById(Long clubId) {
		return clubRepository.findById(clubId).orElseThrow(
				() -> new UserDefineException("존재하지 않는 동호회입니다.")
		);
	}
}
