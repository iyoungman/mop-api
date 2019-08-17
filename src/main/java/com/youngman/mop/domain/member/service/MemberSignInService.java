package com.youngman.mop.domain.member.service;

import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.dto.MemberSignInRequest;
import com.youngman.mop.domain.member.dto.MemberSignInResponse;
import com.youngman.mop.domain.member.exception.InvalidPasswordException;
import com.youngman.mop.domain.member.dao.MemberFindDao;
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


    public MemberSignInResponse singInMember(MemberSignInRequest memberSignInRequest) {
        Member member = memberFindDao.findByEmail(memberSignInRequest.getEmail());

        if (isEqualPw(member.getPw(), memberSignInRequest.getPw())) {
            String token = jwtService.createJwt(member.getEmail(), member.getName());
            return MemberSignInResponse.builder()
                    .token(token)
                    .email(member.getEmail())
                    .name(member.getName())
                    .build();
        }
        throw new InvalidPasswordException();
    }


    private boolean isEqualPw(String pw, String signInPw) {
        return pw.equals(signInPw);
    }
}
