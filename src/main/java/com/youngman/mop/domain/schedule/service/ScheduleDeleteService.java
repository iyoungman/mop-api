package com.youngman.mop.domain.schedule.service;

import com.youngman.mop.board.exception.InvalidWriterException;
import com.youngman.mop.domain.schedule.dao.ScheduleFindDao;
import com.youngman.mop.domain.schedule.dao.ScheduleRepository;
import com.youngman.mop.global.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleDeleteService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleFindDao scheduleFindDao;
    private final JwtService jwtService;


    public void deleteSchedule(Long scheduleId, String token) {
        String findWriter = scheduleFindDao.findWriterById(scheduleId);
        String tokenWriter = jwtService.findNameByJwt(token);
        checkValidateWriter(findWriter, tokenWriter);

        scheduleRepository.deleteById(scheduleId);
    }

    private void checkValidateWriter(String scheduleWriterName, String updateWriterName) {
        if (scheduleWriterName.equals(updateWriterName)) {
            return;
        }
        throw new InvalidWriterException();
    }
}

