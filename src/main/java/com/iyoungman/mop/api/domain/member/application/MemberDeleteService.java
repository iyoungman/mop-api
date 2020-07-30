package com.iyoungman.mop.api.domain.member.application;

import com.iyoungman.mop.api.domain.member.domain.MemberRepository;
import com.iyoungman.mop.api.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
@Transactional
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
