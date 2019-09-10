package com.youngman.mop.domain.schedule.service;

import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.domain.schedule.dto.ScheduleResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-09-05.
 */

@Component
public class ScheduleMapper {

    public List<ScheduleResponse> mapFrom(List<Schedule> schedules) {
        return schedules.stream()
                .map(this::toScheduleResponse)
                .collect(Collectors.toList());
    }

    private ScheduleResponse toScheduleResponse(Schedule schedule) {
        return ScheduleResponse.of(schedule);
    }

    public Map<String, ScheduleResponse> convertListToMap(List<ScheduleResponse> scheduleResponses) {
        return scheduleResponses.stream()
                .collect(Collectors.toMap(ScheduleResponse::getMeetingDateStr, s -> s));
    }

}
