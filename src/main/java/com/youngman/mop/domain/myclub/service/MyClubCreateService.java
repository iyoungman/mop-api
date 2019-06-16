package com.youngman.mop.domain.myclub.service;

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
	private final MemberRepository memberRepository;
	private final ClubRepository clubRepository;

	public void createMyClub(MyClubCreateRequest myClubCreateRequest) {
		MyClub myClub = MyClub.of(
				findMemberByEmail(myClubCreateRequest.getEmail()),
				findClubById(myClubCreateRequest.getClubId())
		);
		myClubRepository.save(myClub);
	}

	private Member findMemberByEmail(String email) {
		return memberRepository.findByEmail(email).orElseThrow(
				() -> new UserDefineException("존재하지 않는 아이디 입니다.")
		);
	}

	private Club findClubById(Long clubId) {
		return clubRepository.findById(clubId).orElseThrow(
				() -> new UserDefineException("존재하지 않는 동호회 입니다.")
		);
	}

}
