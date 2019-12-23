package com.youngman.mop.domain.schedule.service;

import com.youngman.mop.club.command.domain.Club;
import com.youngman.mop.domain.schedule.dto.ScheduleCreateRequest;
import com.youngman.mop.domain.schedule.dao.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleCreateService {

    private final ScheduleRepository scheduleRepository;
    private final ClubFindDao clubFindDao;


    public void createSchedule(ScheduleCreateRequest scheduleCreateRequest) {
        scheduleCreateRequest.timeValidationCheck();

        Club club = clubFindDao.findById(scheduleCreateRequest.getClubId());
        scheduleRepository.save(scheduleCreateRequest.toEntity(club));
    }
}
