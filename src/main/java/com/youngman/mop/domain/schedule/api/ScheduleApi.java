package com.youngman.mop.domain.schedule.api;

import com.youngman.mop.domain.schedule.dao.ScheduleRepository;
import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.domain.schedule.dto.ScheduleCreateRequest;
import com.youngman.mop.domain.schedule.dto.ScheduleUpdateRequest;
import com.youngman.mop.domain.schedule.service.ScheduleCreateService;
import com.youngman.mop.domain.schedule.service.ScheduleDeleteService;
import com.youngman.mop.domain.schedule.service.ScheduleFetchService;
import com.youngman.mop.domain.schedule.service.ScheduleUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-24.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/mop/schedule")
public class ScheduleApi {

	private final ScheduleCreateService scheduleCreateService;
	private final ScheduleFetchService scheduleFetchService;
	private final ScheduleUpdateService scheduleUpdateService;
	private final ScheduleDeleteService scheduleDeleteService;


	@PostMapping
	public void createSchedule(@RequestBody ScheduleCreateRequest scheduleCreateRequest) {
		scheduleCreateService.createSchedule(scheduleCreateRequest);
	}

	@GetMapping("/monthly")
	public List<Schedule> fetchSchedulesByClubIdAndMonthly(@RequestParam("clubId") Long clubId) {
		return scheduleFetchService.fetchSchedulesByClubIdAndMonthly(clubId);
	}

	@PutMapping
	public void updateSchedule(@RequestBody ScheduleUpdateRequest scheduleUpdateRequest) {
		scheduleFetchService.updateSchedule(scheduleUpdateRequest);
	}

	@DeleteMapping
	public void deleteSchedule() {
	}

}
