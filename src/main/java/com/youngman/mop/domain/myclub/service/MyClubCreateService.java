package com.youngman.mop.domain.myclub.service;

import com.youngman.mop.domain.club.repository.ClubFindDao;
import com.youngman.mop.domain.member.repository.MemberFindDao;
import com.youngman.mop.global.error.UserDefineException;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.myclub.domain.MyClub;
import com.youngman.mop.domain.myclub.dto.MyClubCreateRequest;
import com.youngman.mop.domain.club.repository.ClubRepository;
import com.youngman.mop.domain.member.repository.MemberRepository;
import com.youngman.mop.domain.myclub.repository.MyClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-12.
 */

@Service
@RequiredArgsConstructor
public class MyClubCreateService {

	private final MyClubRepository myClubRepository;
	private final MemberFindDao memberFindDao;
	private final ClubFindDao clubFindDao;


	public void createMyClub(MyClubCreateRequest myClubCreateRequest) {
		MyClub myClub = MyClub.of(
				memberFindDao.findByEmail(myClubCreateRequest.getEmail()),
				clubFindDao.findById(myClubCreateRequest.getClubId())
		);

		myClubRepository.save(myClub);
	}

}
