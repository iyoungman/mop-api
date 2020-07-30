package com.iyoungman.mop.api.domain.schedule.application;

import com.iyoungman.mop.api.domain.schedule.api.dto.ScheduleCreateRequest;
import com.iyoungman.mop.api.domain.schedule.domain.Schedule;
import com.iyoungman.mop.api.domain.schedule.domain.ScheduleRepository;
import com.iyoungman.mop.api.domain.schedule.domain.ScheduleValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleCreateService {

    private final ScheduleRepository scheduleRepository;

    private final ScheduleValidator scheduleValidator;

    @Transactional
    public Long createSchedule(ScheduleCreateRequest scheduleCreateRequest) {
        Schedule schedule = scheduleCreateRequest.toEntity();
        schedule.check(scheduleValidator);

        return scheduleRepository.save(schedule).getId();
    }
}
