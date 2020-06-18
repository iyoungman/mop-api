package com.youngman.mop.domain.schedule.domain;

import com.youngman.mop.domain.club.api.ClubScheduleResponse;
import com.youngman.mop.domain.club.command.domain.ClubScheduleService;
import com.youngman.mop.original.schedule.dao.ScheduleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by iyoungman on 2020-06-16.
 */

@Service
@RequiredArgsConstructor
public class ClubScheduleServiceImpl implements ClubScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public List<ClubScheduleResponse> findSchedule(Long clubId) {
        return null;
    }
}
