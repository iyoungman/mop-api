package com.youngman.mop.service.myclub;

import com.youngman.mop.exception.UserDefineException;
import com.youngman.mop.model.domain.Club;
import com.youngman.mop.model.domain.Member;
import com.youngman.mop.model.domain.MyClub;
import com.youngman.mop.model.dto.MyClubCreateRequestDto;
import com.youngman.mop.repository.ClubRepository;
import com.youngman.mop.repository.MemberRepository;
import com.youngman.mop.repository.MyClubRepository;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-12.
 */

@Service
public class MyClubCreateService {

	private final MyClubRepository myClubRepository;
	private final MemberRepository memberRepository;
	private final ClubRepository clubRepository;

	public MyClubCreateService(MyClubRepository myClubRepository, MemberRepository memberRepository, ClubRepository clubRepository) {
		this.myClubRepository = myClubRepository;
		this.memberRepository = memberRepository;
		this.clubRepository = clubRepository;
	}

	public void createMyClub(MyClubCreateRequestDto myClubCreateRequestDto) {
		MyClub myClub = MyClub.of(
				findMemberByEmail(myClubCreateRequestDto.getEmail()),
				findClubById(myClubCreateRequestDto.getClubId())
		);
		myClubRepository.save(myClub);
	}

	//TODO Private
	public Member findMemberByEmail(String email) {
		return memberRepository.findByEmail(email).orElseThrow(
				() -> new UserDefineException("존재하지 않는 아이디 입니다.")
		);
	}

	//TODO Private
	public Club findClubById(Long id) {
		return clubRepository.findById(id).orElseThrow(
				() -> new UserDefineException("존재하지 않는 동호회 입니다.")
		);
	}

}
