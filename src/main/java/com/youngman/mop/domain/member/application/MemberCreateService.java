package com.youngman.mop.domain.member.application;

import com.youngman.mop.domain.member.exception.EmailDuplicationException;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.api.dto.MemberCreateRequest;
import com.youngman.mop.domain.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
@RequiredArgsConstructor
public class MemberCreateService {

    private final MemberRepository memberRepository;

    public Long createMember(MemberCreateRequest memberCreateRequest) {
        if (!memberRepository.existsByEmail(memberCreateRequest.getEmail())) {
            Member member = memberRepository.save(memberCreateRequest.toEntity());
            return member.getId();
        }
        throw new EmailDuplicationException();
    }

}
