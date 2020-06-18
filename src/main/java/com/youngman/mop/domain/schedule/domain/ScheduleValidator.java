package com.youngman.mop.domain.schedule.domain;

import com.youngman.mop.domain.club.domain.ClubRepository;
import com.youngman.mop.domain.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by iyoungman on 2020-06-16.
 */

@Service
@RequiredArgsConstructor
public class ScheduleValidator {

    private final ClubRepository clubRepository;

    private final MemberRepository memberRepository;


}
