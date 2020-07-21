package com.youngman.mop.domain.schedule.application;

import com.youngman.mop.core.jwt.Claim;
import com.youngman.mop.core.jwt.JwtService;
import com.youngman.mop.domain.board.exception.InvalidWriterException;
import com.youngman.mop.domain.schedule.domain.ScheduleRepository;
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
//        String findWriter = scheduleRepository.findWriterById(scheduleId);
        String findWriter = null;

        Claim claim = jwtService.decode(token);
        String tokenWriter = claim.getName();

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

