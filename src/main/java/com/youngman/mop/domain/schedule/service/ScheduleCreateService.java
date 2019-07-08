package com.youngman.mop.domain.schedule.service;

import com.youngman.mop.domain.club.dao.ClubFindDao;
import com.youngman.mop.domain.schedule.exception.InvalidMeetingTimeException;
import com.youngman.mop.global.error.UserDefineException;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.domain.schedule.dto.ScheduleCreateRequest;
import com.youngman.mop.domain.club.dao.ClubRepository;
import com.youngman.mop.domain.schedule.dao.ScheduleRepository;
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
	private final ClubFindDao clubFindDao;


	public void createSchedule(ScheduleCreateRequest scheduleCreateRequest) {
		timeValidationCheck(scheduleCreateRequest.getMeetingTime());

		scheduleRepository.save(Schedule.of(scheduleCreateRequest,
				clubFindDao.findById(scheduleCreateRequest.getClubId()))
		);
	}

	private void timeValidationCheck(LocalDateTime meetingTime) {
		Predicate<LocalDateTime> predicate = time -> time.isAfter(LocalDateTime.now());
		if (!predicate.test(meetingTime)) {
			throw new InvalidMeetingTimeException();
		}
	}


}
