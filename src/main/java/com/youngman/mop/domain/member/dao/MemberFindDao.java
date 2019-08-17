package com.youngman.mop.domain.member.dao;

import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by YoungMan on 2019-06-17.
 */

@Service
@RequiredArgsConstructor
public class MemberFindDao {

    private final MemberRepository memberRepository;


    public Member findByEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        member.orElseThrow(MemberNotFoundException::new);
        return member.get();
    }

    public String findAddressByEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        member.orElseThrow(MemberNotFoundException::new);
        return member.get().getAddress();
    }

}
