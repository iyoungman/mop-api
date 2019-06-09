package com.youngman.mop.service.schedule;

import com.youngman.mop.exception.UserDefineException;
import com.youngman.mop.domain.entity.Club;
import com.youngman.mop.domain.entity.Schedule;
import com.youngman.mop.domain.dto.ScheduleCreateRequestDto;
import com.youngman.mop.repository.ClubRepository;
import com.youngman.mop.repository.ScheduleRepository;
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

	public void createSchedule(ScheduleCreateRequestDto scheduleCreateRequestDto) {
		timeValidationCheck(scheduleCreateRequestDto.getMeetingTime());

		scheduleRepository.save(Schedule.of(scheduleCreateRequestDto,
				findById(scheduleCreateRequestDto.getClubId()))
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
