package com.youngman.mop.service.myclub;

import com.youngman.mop.exception.UserDefineException;
import com.youngman.mop.domain.entity.Club;
import com.youngman.mop.domain.entity.Member;
import com.youngman.mop.domain.entity.MyClub;
import com.youngman.mop.domain.dto.MyClubCreateRequestDto;
import com.youngman.mop.repository.ClubRepository;
import com.youngman.mop.repository.MemberRepository;
import com.youngman.mop.repository.MyClubRepository;
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

	public void createMyClub(MyClubCreateRequestDto myClubCreateRequestDto) {
		MyClub myClub = MyClub.of(
				findMemberByEmail(myClubCreateRequestDto.getEmail()),
				findClubById(myClubCreateRequestDto.getClubId())
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
