package com.youngman.mop.domain.schedule.service;

import com.youngman.mop.core.jwt.Claim;
import com.youngman.mop.core.jwt.JwtService;
import com.youngman.mop.domain.board.exception.InvalidWriterException;
import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.original.schedule.dao.ScheduleFindDao;
import com.youngman.mop.original.schedule.dao.ScheduleRepository;
import com.youngman.mop.original.schedule.dto.ScheduleUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleUpdateService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleFindDao scheduleFindDao;
    private final JwtService jwtService;


    public void updateSchedule(ScheduleUpdateRequest scheduleUpdateRequest, String token) {
        Schedule schedule = scheduleFindDao.findById(scheduleUpdateRequest.getScheduleId());

        Claim claim = jwtService.decode(token);

        checkValidateWriter(schedule.getWriter(), claim.getName());

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
