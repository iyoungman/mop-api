package com.youngman.mop.domain.club;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.youngman.mop.domain.board.application.BoardDeleteService;
import com.youngman.mop.domain.board.domain.BoardRepository;
import com.youngman.mop.domain.club.api.dto.ClubCreateRequest;
import com.youngman.mop.domain.club.application.ClubDeleteService;
import com.youngman.mop.domain.club.domain.ClubChair;
import com.youngman.mop.domain.club.domain.ClubRepository;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.domain.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
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
public class ClubDeleteServiceTest {

    @Autowired
    private ClubDeleteService clubDeleteService;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private MemberRepository memberRepository;

    private Long clubId;

    private Long chairManId;

    @BeforeEach
    public void init() {
        Member member = memberRepository.save(Member.builder().build());
        chairManId = member.getId();
        ClubChair clubChair = new ClubChair(member.getId());

        ClubCreateRequest request = ClubCreateRequest.builder()
                .name("name")
                .introduce("introduce")
                .clubChair(clubChair)
                .build();

        clubId = clubRepository.save(request.toEntity()).getId();
    }

    @Test
    @DisplayName("동호회 정상 삭제")
    public void deleteClubCorrect() {
        clubDeleteService.deleteClub(clubId, chairManId);

        boolean result = clubRepository.findById(clubId).isPresent();
        assertFalse(result);
    }

    @Test
    @DisplayName("동호회장이 아닐 경우 삭제 실패")
    public void deleteClubAtNotClubChair() {
        Long invalidChairManId = 111L;

        assertThrows(RuntimeException.class, () -> clubDeleteService.deleteClub(clubId, invalidChairManId));
    }
}
