package com.youngman.mop.service.club;

import com.youngman.mop.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubDeleteService {

	private final ClubRepository clubRepository;

	public void deleteClub(Long clubId) {
		clubRepository.deleteById(clubId);
	}
}
