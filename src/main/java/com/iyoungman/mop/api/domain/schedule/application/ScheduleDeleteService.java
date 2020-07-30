package com.iyoungman.mop.api.domain.schedule.application;

import com.iyoungman.mop.api.core.jwt.Claim;
import com.iyoungman.mop.api.core.jwt.JwtService;
import com.iyoungman.mop.api.domain.schedule.domain.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleDeleteService {

    private final ScheduleRepository scheduleRepository;

    private final JwtService jwtService;

    public void deleteSchedule(Long scheduleId, String token) {
        String writer = scheduleRepository.findByWriter(scheduleId);

        Claim claim = jwtService.decode(token);
        claim.check(writer, writer);

        scheduleRepository.deleteById(scheduleId);
    }
}

