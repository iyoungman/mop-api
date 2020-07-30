package com.iyoungman.mop.api.domain.member.application;

import com.iyoungman.mop.api.domain.member.api.dto.MemberCreateRequest;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.iyoungman.mop.api.domain.member.domain.MemberRepository;
import com.iyoungman.mop.api.domain.member.exception.EmailDuplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
@Transactional
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
