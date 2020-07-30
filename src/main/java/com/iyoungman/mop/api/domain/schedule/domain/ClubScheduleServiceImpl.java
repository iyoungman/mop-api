package com.iyoungman.mop.api.domain.schedule.domain;

import com.iyoungman.mop.api.domain.club.api.response.ClubScheduleResponse;
import com.iyoungman.mop.api.domain.club.domain.ClubScheduleService;
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
