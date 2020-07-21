package com.youngman.mop.domain.schedule.application;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.schedule.api.dto.ScheduleCreateRequest;
import com.youngman.mop.domain.schedule.domain.ScheduleRepository;
import com.youngman.mop.domain.schedule.domain.ScheduleValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleCreateService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleValidator scheduleValidator;

    public void createSchedule(ScheduleCreateRequest scheduleCreateRequest) {
        scheduleCreateRequest.timeValidationCheck();

        //TODO scheduleValidator 검증

        scheduleRepository.save(scheduleCreateRequest.toEntity());
    }
}
