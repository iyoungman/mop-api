package com.iyoungman.mop.api.domain.member.application;

import com.iyoungman.mop.api.domain.member.api.dto.MemberCreateRequest;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.iyoungman.mop.api.domain.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
@RequiredArgsConstructor
public class MemberUpdateService {

    private final MemberRepository memberRepository;

    /**
     * Email 은 변경 못함
     */
    public void updateMember(MemberCreateRequest memberCreateRequest) {
        Member member = memberRepository.findByEmail(memberCreateRequest.getEmail()).get();
        member.updateMember(memberCreateRequest);
        memberRepository.save(member);
    }

}
