package com.youngman.mop.member.service;

import com.youngman.mop.member.exception.EmailDuplicationException;
import com.youngman.mop.member.domain.Member;
import com.youngman.mop.member.controller.MemberCreateRequest;
import com.youngman.mop.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
@RequiredArgsConstructor
public class MemberCreateService {

    private final MemberRepository memberRepository;


    public void createMember(MemberCreateRequest memberCreateRequest) {

        if (!memberRepository.existsByEmail(memberCreateRequest.getEmail())) {
            memberRepository.save(Member.of(memberCreateRequest));
            return;
        }
        throw new EmailDuplicationException();
    }

}
