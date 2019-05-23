package com.youngman.mop.service.member;

import com.youngman.mop.exception.UserDefineException;
import com.youngman.mop.model.Member;
import com.youngman.mop.model.dto.SignUpRequestDto;
import com.youngman.mop.repository.MemberRepository;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
public class MemberCreateService {

	private final MemberRepository memberRepository;

	public MemberCreateService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void signUp(SignUpRequestDto signUpRequestDto) {

		if (!memberRepository.existsByEmail(signUpRequestDto.getEmail())) {
			memberRepository.save(Member.of(signUpRequestDto));
		}
		throw new UserDefineException("이미 존재하는 이메일 입니다.");
	}

}
