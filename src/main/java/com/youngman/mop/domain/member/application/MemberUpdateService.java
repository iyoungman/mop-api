package com.youngman.mop.domain.member.application;

import com.youngman.mop.domain.member.api.dto.MemberCreateRequest;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-10.
 * Email 은 변경 못함
 */

@Service
@RequiredArgsConstructor
public class MemberUpdateService {

    private final MemberRepository memberRepository;

    public void updateMember(MemberCreateRequest memberCreateRequest) {
        Member member = memberRepository.findByEmail(memberCreateRequest.getEmail()).get();
        member.updateMember(memberCreateRequest);
        memberRepository.save(member);
    }

}
