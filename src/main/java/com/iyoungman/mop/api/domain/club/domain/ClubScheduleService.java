package com.iyoungman.mop.api.domain.club.domain;

import com.iyoungman.mop.api.domain.club.api.response.ClubScheduleResponse;
import java.util.List;

/**
 * Created by iyoungman on 2020-06-16.
 */

public interface ClubScheduleService {

    List<ClubScheduleResponse> findSchedule(Long clubId);
}
