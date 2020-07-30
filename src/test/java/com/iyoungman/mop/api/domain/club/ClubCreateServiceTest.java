package com.iyoungman.mop.api.domain.club;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.iyoungman.mop.api.domain.club.api.request.ClubCreateRequest;
import com.iyoungman.mop.api.domain.club.application.ClubCreateService;
import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.club.domain.ClubChair;
import com.iyoungman.mop.api.domain.club.domain.ClubRepository;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.iyoungman.mop.api.domain.member.domain.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by iyoungman on 2020-07-21.
 */

@Transactional
@SpringBootTest
public class ClubCreateServiceTest {

    @Autowired
    private ClubCreateService clubCreateService;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("동호회 등록 성공 테스트")
    public void createClub() {
        Member member = memberRepository.save(Member.builder().build());
        ClubChair clubChair = new ClubChair(member.getId());

        ClubCreateRequest request = ClubCreateRequest.builder()
                .name("name")
                .introduce("introduce")
                .clubChair(clubChair)
                .build();

        Long id = clubCreateService.createClub(request);
        Club club = clubRepository.findById(id).get();

        assertEquals(request.getName(), club.getName());
        assertEquals(request.getIntroduce(), club.getIntroduce());
    }
}
