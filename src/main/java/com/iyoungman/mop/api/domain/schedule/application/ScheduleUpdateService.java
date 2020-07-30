package com.iyoungman.mop.api.domain.schedule.application;

import com.iyoungman.mop.api.core.jwt.Claim;
import com.iyoungman.mop.api.core.jwt.JwtService;
import com.iyoungman.mop.api.domain.schedule.api.dto.ScheduleUpdateRequest;
import com.iyoungman.mop.api.domain.schedule.domain.Schedule;
import com.iyoungman.mop.api.domain.schedule.domain.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleUpdateService {

    private final ScheduleRepository scheduleRepository;

    private final JwtService jwtService;

    public void updateSchedule(ScheduleUpdateRequest scheduleUpdateRequest, String token) {
        Schedule schedule = scheduleRepository.findById(scheduleUpdateRequest.getScheduleId()).get();

        Claim claim = jwtService.decode(token);

//        checkValidateWriter(schedule.getWriterId(), claim.getName());

        schedule.updateSchedule(scheduleUpdateRequest);
        scheduleRepository.save(schedule);
    }
}
