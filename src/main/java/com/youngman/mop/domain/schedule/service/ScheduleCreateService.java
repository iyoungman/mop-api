package com.youngman.mop.domain.schedule.service;

import com.youngman.mop.global.error.UserDefineException;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.domain.schedule.dto.ScheduleCreateRequest;
import com.youngman.mop.domain.club.repository.ClubRepository;
import com.youngman.mop.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.function.Predicate;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleCreateService {

	private final ScheduleRepository scheduleRepository;
	private final ClubRepository clubRepository;

	public void createSchedule(ScheduleCreateRequest scheduleCreateRequest) {
		timeValidationCheck(scheduleCreateRequest.getMeetingTime());

		scheduleRepository.save(Schedule.of(scheduleCreateRequest,
				findById(scheduleCreateRequest.getClubId()))
		);
	}

	private void timeValidationCheck(LocalDateTime meetingTime) {
		Predicate<LocalDateTime> predicate = time -> time.isAfter(LocalDateTime.now());
		if (!predicate.test(meetingTime)) {
			throw new UserDefineException("모임 시간은 현재 시간 이후여야 합니다.");
		}
	}

	private Club findById(Long clubId) {
		return clubRepository.findById(clubId).orElseThrow(
				() -> new UserDefineException("존재하지 않는 동호회입니다.")
		);
	}

}
