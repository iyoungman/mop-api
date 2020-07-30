package com.iyoungman.mop.api.domain.member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.iyoungman.mop.api.domain.member.api.dto.MemberCreateRequest;
import com.iyoungman.mop.api.domain.member.application.MemberCreateService;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.iyoungman.mop.api.domain.member.domain.MemberRepository;
import com.iyoungman.mop.api.domain.member.exception.EmailDuplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by iyoungman on 2020-07-20.
 */

@Transactional
@SpringBootTest
public class MemberCreateServiceTest {

    @Autowired
    private MemberCreateService memberCreateService;

    @Autowired
    private MemberRepository memberRepository;

    private String duplicateEmail = "email";

    @BeforeEach
    public void init() {
        MemberCreateRequest request = MemberCreateRequest.builder()
                .email(duplicateEmail)
                .address("address")
                .build();

        Member member = request.toEntity();

        memberRepository.save(member);
    }

    @Test
    @DisplayName("멤버 정상 생성 테스트")
    public void createMemberCorrect() {
        MemberCreateRequest request = MemberCreateRequest.builder()
                .email("email2")
                .address("address")
                .build();

        Long id = memberCreateService.createMember(request);
        Member member = memberRepository.findById(id).get();

        assertEquals(request.getEmail(), member.getEmail());
    }

    @Test
    @DisplayName("멤버 이메일 중복 테스트")
    public void createMemberEmailDuplicate() {
        MemberCreateRequest request = MemberCreateRequest.builder()
                .email(duplicateEmail)
                .address("address")
                .build();

        assertThrows(EmailDuplicationException.class, () -> memberCreateService.createMember(request));
    }
}
