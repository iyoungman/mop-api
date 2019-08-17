package com.youngman.mop.domain.schedule.service;

import com.youngman.mop.domain.schedule.dao.ScheduleRepository;
import com.youngman.mop.domain.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleFetchService {

    private final ScheduleRepository scheduleRepository;


    public Map<String, Schedule> fetchSchedulesByClubIdAndMonthly(Long clubId, LocalDate date) {
        List<Schedule> schedules = scheduleRepository.fetchSchedulesByClubIdAndMonthly(clubId, date);
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
