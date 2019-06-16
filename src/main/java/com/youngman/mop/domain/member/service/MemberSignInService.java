package com.youngman.mop.domain.member.service;

import com.youngman.mop.global.error.UserDefineException;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.dto.MemberSignInRequest;
import com.youngman.mop.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-25.
 */

@Service
@RequiredArgsConstructor
public class MemberSignInService {

	private final MemberRepository memberRepository;
	private final JwtService jwtService;


	public boolean singIn(MemberSignInRequest memberSignInRequest) {
		Member member = findByEmail(memberSignInRequest.getEmail());

		if(!isEqualPw(member.getPw(), memberSignInRequest.getPw())) {
			throw new UserDefineException("비밀번호가 틀렸습니다.");
		}
		return true;
	}

	private Member findByEmail(String email) {
		return memberRepository.findByEmail(email).orElseThrow(
				() -> new UserDefineException("존재하지 않는 회원입니다.")
		);
	}

	private boolean isEqualPw(String pw, String signInPw) {
		return pw.equals(signInPw);
	}
}
