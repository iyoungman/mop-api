package com.iyoungman.mop.api.domain.myclub.application;

import com.google.common.collect.Lists;
import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.club.domain.ClubRepository;
import com.iyoungman.mop.api.domain.myclub.api.dto.MyClubResponse;
import com.iyoungman.mop.api.domain.myclub.domain.MyClubRepository;
import com.iyoungman.mop.api.domain.schedule.domain.ScheduleRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class MyClubFindService {

    private final MyClubRepository myClubRepository;

    private final ClubRepository clubRepository;

    private final ScheduleRepository scheduleRepository;

    @Transactional(readOnly = true)
    public List<MyClubResponse> findMyClubsByMemberId(Long memberId) {
        List<MyClubResponse> myClubResponses = Lists.newArrayList();

        //ClubId 조회
        List<Long> clubIds = myClubRepository.findClubIdsByMemberId(memberId);

        //동호회 조회
        List<Club> clubs = clubRepository.findAllById(clubIds);

        //동호회 별 Schedule + DTO 조립
        for (Club club : clubs) {
            myClubResponses.add(makeMyClubResponse(club));
        }

        return myClubResponses;
    }

    private MyClubResponse makeMyClubResponse(Club club) {
        LocalDateTime upComingMeetingDate = scheduleRepository.findMeetingTimeByUpcoming(club.getId())
                .orElse(null);

        return MyClubResponse.builder()
                .club(club)
                .upComingMeetingDate(upComingMeetingDate)
                .build();
    }
}
