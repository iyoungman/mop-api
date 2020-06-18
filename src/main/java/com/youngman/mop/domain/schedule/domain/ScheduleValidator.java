package com.youngman.mop.domain.schedule.domain;

import com.youngman.mop.domain.club.command.domain.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by iyoungman on 2020-06-16.
 */

@Service
@RequiredArgsConstructor
public class ScheduleValidator {

    private final ClubRepository clubRepository;
}
