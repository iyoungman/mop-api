package com.iyoungman.mop.api.domain.schedule.domain;

import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.club.domain.ClubRepository;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.iyoungman.mop.api.domain.member.domain.MemberRepository;
import com.iyoungman.mop.api.domain.schedule.exception.InvalidMeetingTimeException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Predicate;
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

    public void validate(Schedule schedule) {
        if (!getClub(schedule).isPresent()) {
            throw new IllegalArgumentException("삭제된 동호회 입니다.");
        }

        if (!getWriter(schedule).isPresent()) {
            throw new IllegalArgumentException("탈퇴한 멤버입니다.");
        }

        if (!isValidMeetingTime(schedule.getMeetingTime())) {
            throw new InvalidMeetingTimeException();
        }
    }

    private Optional<Club> getClub(Schedule schedule) {
        return clubRepository.findById(schedule.getClubId());
    }

    private Optional<Member> getWriter(Schedule schedule) {
        return memberRepository.findById(schedule.getWriterId());
    }

    private boolean isValidMeetingTime(LocalDateTime meetingTime) {
        Predicate<LocalDateTime> predicate = time -> time.isAfter(LocalDateTime.now().plusHours(1));//1시간 이후
        return predicate.test(meetingTime);
    }
}
