package com.youngman.mop.domain.member.application;

import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.dto.MemberCreateRequest;
import com.youngman.mop.domain.member.infra.repository.MemberFindDao;
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
    private final MemberFindDao memberFindDao;


    public void updateMember(MemberCreateRequest memberCreateRequest) {
        Member member = memberFindDao.findByEmail(memberCreateRequest.getEmail());
        member.updateMember(memberCreateRequest);
        memberRepository.save(member);
    }

}
