package com.iyoungman.mop.api.domain.member.application;

import com.iyoungman.mop.api.core.jwt.JwtService;
import com.iyoungman.mop.api.domain.member.api.dto.MemberSignInRequest;
import com.iyoungman.mop.api.domain.member.api.dto.MemberSignInResponse;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.iyoungman.mop.api.domain.member.domain.MemberRepository;
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

        String token = jwtService.encode(1L, member.getEmail(), member.getName());

        return MemberSignInResponse.builder()
                .token(token)
                .email(member.getEmail())
                .name(member.getName())
                .build();
    }

}
