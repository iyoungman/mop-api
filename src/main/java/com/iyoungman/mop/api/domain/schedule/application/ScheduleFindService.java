package com.iyoungman.mop.api.domain.schedule.application;

import com.iyoungman.mop.api.domain.schedule.domain.Schedule;
import com.iyoungman.mop.api.domain.schedule.domain.ScheduleRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleFindService {

    private final ScheduleRepository scheduleRepository;

    @Transactional(readOnly = true)
    public LocalDateTime findMeetingTimeByUpcoming(Long clubId) {
        Optional<LocalDateTime> result =  scheduleRepository.findMeetingTimeByUpcoming(clubId);
        return result.orElse(null);
    }

    @Transactional(readOnly = true)
    public Map<String, Schedule> findSchedulesByClubIdAndMonthly(Long clubId, LocalDate date) {
        List<Schedule> schedules = scheduleRepository.findSchedulesByClubIdAndMonthly(clubId, date);
        return convertListToMap(schedules);
    }

    private Map<String, Schedule> convertListToMap(List<Schedule> schedules) {
        return schedules.stream()
                .collect(Collectors.toMap(s -> convertTimeToDateStr(s.getMeetingTime()), s -> s));
    }

    private String convertTimeToDateStr(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate()
                .toString();
    }


}
