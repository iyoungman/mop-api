package com.youngman.mop.myclub.service;

import com.youngman.mop.myclub.domain.MyClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-13.
 */

@Service
@RequiredArgsConstructor
public class MyClubDeleteService {

	private final MyClubRepository myClubRepository;

	public void deleteMyClub(String email, Long clubId) {
		myClubRepository.deleteByMemberAndAndClub(email, clubId);
	}
}