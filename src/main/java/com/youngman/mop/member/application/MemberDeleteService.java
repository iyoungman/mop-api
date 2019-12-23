package com.youngman.mop.member.application;

import com.youngman.mop.member.exception.MemberNotFoundException;
import com.youngman.mop.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
@RequiredArgsConstructor
public class MemberDeleteService {

    private final MemberRepository memberRepository;


    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    public void deleteByEmail(String email) {
        if (memberRepository.existsByEmail(email)) {
            memberRepository.deleteByEmail(email);
            return;
        }
        throw new MemberNotFoundException();
    }
}