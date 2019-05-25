package com.youngman.mop.service.member;

import com.youngman.mop.exception.UserDefineException;
import com.youngman.mop.model.domain.Member;
import com.youngman.mop.model.dto.MemberSignInRequestDto;
import com.youngman.mop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-25.
 */

@Service
@RequiredArgsConstructor
public class MemberSignInService {

	private final MemberRepository memberRepository;

	public boolean singIn(MemberSignInRequestDto memberSignInRequestDto) {
		Member member = findByEmail(memberSignInRequestDto.getEmail());

		if(!isEqualPw(member.getPw(), memberSignInRequestDto.getPw())) {
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
