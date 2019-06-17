package com.youngman.mop.domain.member.service;

import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.dto.MemberSignInRequest;
import com.youngman.mop.domain.member.exception.InvalidPasswordException;
import com.youngman.mop.domain.member.repository.MemberFindDao;
import com.youngman.mop.global.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-25.
 */

@Service
@RequiredArgsConstructor
public class MemberSignInService {

	private final MemberFindDao memberFindDao;
	private final JwtService jwtService;


	public String singInMember(MemberSignInRequest memberSignInRequest) {
		Member member = memberFindDao.findByEmail(memberSignInRequest.getEmail());

		if(isEqualPw(member.getPw(), memberSignInRequest.getPw())) {
			return jwtService.createJwt(member.getEmail());
		}
		throw new InvalidPasswordException();
	}


	private boolean isEqualPw(String pw, String signInPw) {
		return pw.equals(signInPw);
	}
}
