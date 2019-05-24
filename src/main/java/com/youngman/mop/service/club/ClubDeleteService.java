package com.youngman.mop.service.club;

import com.youngman.mop.repository.ClubRepository;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
public class ClubDeleteService {

	private final ClubRepository clubRepository;

	public ClubDeleteService(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	public void deleteClub(Long clubId) {
		clubRepository.deleteById(clubId);
	}
}
