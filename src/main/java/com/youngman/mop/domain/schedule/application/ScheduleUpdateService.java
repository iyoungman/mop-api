package com.youngman.mop.domain.schedule.application;

import com.youngman.mop.core.jwt.Claim;
import com.youngman.mop.core.jwt.JwtService;
import com.youngman.mop.domain.board.exception.InvalidWriterException;
import com.youngman.mop.domain.schedule.api.dto.ScheduleUpdateRequest;
import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.domain.schedule.domain.ScheduleRepository;
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

//        checkValidateWriter(schedule.getWriter(), claim.getName());

        schedule.updateSchedule(scheduleUpdateRequest);
        scheduleRepository.save(schedule);
    }

    private void checkValidateWriter(String scheduleWriterName, String updateWriterName) {
        if (scheduleWriterName.equals(updateWriterName)) {
            return;
        }
        throw new InvalidWriterException();
    }

}
