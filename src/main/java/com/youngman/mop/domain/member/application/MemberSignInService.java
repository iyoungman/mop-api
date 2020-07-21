package com.youngman.mop.domain.member.application;

import com.youngman.mop.core.jwt.JwtService;
import com.youngman.mop.domain.member.api.dto.MemberSignInRequest;
import com.youngman.mop.domain.member.api.dto.MemberSignInResponse;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.domain.MemberRepository;
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

    public MemberSignInResponse singInMember(MemberSignInRequest memberSignInRequest) {
        Member member = memberRepository.findByEmail(memberSignInRequest.getEmail()).get();
        member.checkPassword(memberSignInRequest.getPw());

        String token = jwtService.encode(member.getEmail(), member.getName());

        return MemberSignInResponse.builder()
                .token(token)
                .email(member.getEmail())
                .name(member.getName())
                .build();
    }

}
