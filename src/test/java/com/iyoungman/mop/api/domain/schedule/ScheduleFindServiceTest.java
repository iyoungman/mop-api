package com.iyoungman.mop.api.domain.schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.iyoungman.mop.api.domain.schedule.application.ScheduleFindService;
import com.iyoungman.mop.api.domain.schedule.domain.Schedule;
import com.iyoungman.mop.api.domain.schedule.domain.ScheduleRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by iyoungman on 2020-07-22.
 */

@Transactional
@SpringBootTest
public class ScheduleFindServiceTest {

    @Autowired
    private ScheduleFindService scheduleFindService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    @DisplayName("다가오는 스케줄 중 최신 날짜 하나 조회")
    public void findMeetingTimeByUpcomingTest() {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        LocalDateTime dayAfterTomorrow = LocalDateTime.now().plusDays(1);

        Long clubId = 1L;

        List<Schedule> schedules = Lists.newArrayList(
                Schedule.builder()
                        .meetingTime(yesterday)
                        .clubId(clubId)
                        .build(),
                Schedule.builder()
                        .meetingTime(tomorrow)
                        .clubId(clubId)
                        .build(),
                Schedule.builder()
                        .meetingTime(dayAfterTomorrow)
                        .clubId(clubId)
                        .build()
        );

        scheduleRepository.saveAll(schedules);

        LocalDateTime result = scheduleFindService.findMeetingTimeByUpcoming(clubId);

        assertEquals(tomorrow, result);
    }

    @Test
    @DisplayName("인자로 주어진 날짜의 달 스케쥴 조회")
    public void findSchedulesByClubIdAndMonthlyTest() {
        LocalDateTime meeting1 = LocalDateTime.of(2020, 7, 22, 7, 7, 7);
        LocalDateTime meeting2 = LocalDateTime.of(2020, 7, 23, 7, 7, 7);
        LocalDateTime meeting3 = LocalDateTime.of(2020, 7, 24, 7, 7, 7);
        LocalDateTime meeting4 = LocalDateTime.of(2020, 8, 3, 7, 7, 7);

        Long clubId = 1L;

        List<Schedule> schedules = Lists.newArrayList(
                Schedule.builder()
                        .meetingTime(meeting1)
                        .clubId(clubId)
                        .build(),
                Schedule.builder()
                        .meetingTime(meeting2)
                        .clubId(clubId)
                        .build(),
                Schedule.builder()
                        .meetingTime(meeting3)
                        .clubId(clubId)
                        .build(),
                Schedule.builder()
                        .meetingTime(meeting4)
                        .clubId(clubId)
                        .build()
        );

        scheduleRepository.saveAll(schedules);

        Map<String, Schedule> result = scheduleFindService.findSchedulesByClubIdAndMonthly(
                clubId,
                LocalDate.of(2020, 7, 22)
        );

        assertEquals(3, result.size());
    }
}
