package com.youngman.mop.domain.myclub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.google.common.collect.Lists;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.domain.ClubRepository;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.domain.MemberRepository;
import com.youngman.mop.domain.myclub.api.dto.MyClubCreateRequest;
import com.youngman.mop.domain.myclub.api.dto.MyClubResponse;
import com.youngman.mop.domain.myclub.application.MyClubFindService;
import com.youngman.mop.domain.myclub.domain.MyClubRepository;
import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.domain.schedule.domain.ScheduleRepository;
import java.time.LocalDateTime;
import java.util.List;
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
public class MyClubFindServiceTest {

    @Autowired
    private MyClubFindService myClubFindService;

    @Autowired
    private MyClubRepository myClubRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    private Long memberId;

    @BeforeEach
    public void init() {
        //Member
         Member member = Member.builder()
                .email("email")
                .build();

        memberId = memberRepository.save(member).getId();

        //Club
        Club club = Club.builder()
                .name("club")
                .introduce("introduce")
                .build();

        Club club2 = Club.builder()
                .name("club")
                .introduce("introduce")
                .build();

        Long clubId = clubRepository.save(club).getId();
        Long clubId2 = clubRepository.save(club2).getId();

        //MyClub
        MyClubCreateRequest request = MyClubCreateRequest.builder()
                .clubId(clubId)
                .memberId(memberId)
                .build();

        MyClubCreateRequest request2 = MyClubCreateRequest.builder()
                .clubId(clubId2)
                .memberId(memberId)
                .build();

        myClubRepository.saveAll(Lists.newArrayList(request.toEntity(), request2.toEntity()));

        //Schedule
        Schedule schedule = Schedule.builder()
                .clubId(clubId)
                .meetingTime(LocalDateTime.now().plusDays(2))//2일후
                .build();

        Schedule schedule2 = Schedule.builder()
                .clubId(clubId2)
                .meetingTime(LocalDateTime.now().plusDays(1))//1일후
                .build();

        scheduleRepository.saveAll(Lists.newArrayList(schedule, schedule2));
    }

    @Test
    @DisplayName("멤버 Id로 가입된 동호회, 해당 동호회의 다가오는 최신 일정 가져오기")
    public void findMyClubsByMemberId() {
        List<MyClubResponse> myClubResponses = myClubFindService.findMyClubsByMemberId(memberId);

        assertEquals(2, myClubResponses.size());
        assertNotNull(myClubResponses.get(0).getUpComingMeetingDate());
        assertNotNull(myClubResponses.get(1).getUpComingMeetingDate());
    }
}
