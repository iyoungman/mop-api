package com.youngman.mop.domain.myclub.service;

import com.youngman.mop.domain.myclub.dao.MyClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-13.
 */

@Service
@RequiredArgsConstructor
public class MyClubDeleteService {

	private final MyClubRepository myClubRepository;

	/*public void deleteMyClub(Long myClubId) {
		myClubRepository.deleteById(myClubId);
	}*/

	public void deleteMyClub(String email, Long clubId) {
		myClubRepository.deleteByMemberAndAndClub(email, clubId);
	}
}
