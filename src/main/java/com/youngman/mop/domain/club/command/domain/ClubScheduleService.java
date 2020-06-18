package com.youngman.mop.domain.club.command.domain;

import com.youngman.mop.domain.club.api.ClubScheduleResponse;
import java.util.List;

/**
 * Created by iyoungman on 2020-06-16.
 */

public interface ClubScheduleService {

    List<ClubScheduleResponse> findSchedule(Long clubId);
}
