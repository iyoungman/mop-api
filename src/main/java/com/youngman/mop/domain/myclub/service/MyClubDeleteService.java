package com.youngman.mop.domain.myclub.service;

import com.youngman.mop.domain.member.dao.MemberFindDao;
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
	private final MemberFindDao memberFindDao;

	public void deleteMyClub(String email, Long clubId) {
		Long memberId = memberFindDao.findByEmail(email).getId();
		myClubRepository.deleteByMemberAndAndClub(memberId, clubId);
	}
}
