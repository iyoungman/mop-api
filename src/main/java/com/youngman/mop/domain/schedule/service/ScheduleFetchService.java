package com.youngman.mop.domain.schedule.service;

import com.youngman.mop.domain.schedule.dao.ScheduleRepository;
import com.youngman.mop.domain.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleFetchService {

	private final ScheduleRepository scheduleRepository;


	public List<Schedule> fetchSchedulesByClubIdAndMonthly(Long clubId) {
		return scheduleRepository.fetchSchedulesByClubIdAndMonthly(clubId);
	}
}
