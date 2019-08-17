package com.youngman.mop.domain.schedule.service;

import com.youngman.mop.domain.board.exception.InvalidWriterException;
import com.youngman.mop.domain.schedule.dao.ScheduleFindDao;
import com.youngman.mop.domain.schedule.dao.ScheduleRepository;
import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.domain.schedule.dto.ScheduleUpdateRequest;
import com.youngman.mop.global.jwt.JwtService;
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
        checkValidateWriter(schedule.getWriter(), jwtService.findNameByJwt(token));
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
