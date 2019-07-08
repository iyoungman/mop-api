package com.youngman.mop.domain.schedule.api;

import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.domain.schedule.dto.ScheduleCreateRequest;
import com.youngman.mop.domain.schedule.dto.ScheduleUpdateRequest;
import com.youngman.mop.domain.schedule.service.ScheduleCreateService;
import com.youngman.mop.domain.schedule.service.ScheduleDeleteService;
import com.youngman.mop.domain.schedule.service.ScheduleFetchService;
import com.youngman.mop.domain.schedule.service.ScheduleUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
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
	public Map<String, Schedule> fetchSchedulesByClubIdAndMonthly(@RequestParam("clubId") Long clubId,
																  @DateTimeFormat(pattern = "yyyy-MM-dd")
																  @RequestParam("date") LocalDate date) {

		return scheduleFetchService.fetchSchedulesByClubIdAndMonthly(clubId, date);
	}

	@PutMapping
	public void updateSchedule(@RequestBody ScheduleUpdateRequest scheduleUpdateRequest,
							   @RequestHeader("token") String token) {

		scheduleUpdateService.updateSchedule(scheduleUpdateRequest, token);
	}

	@DeleteMapping
	public void deleteSchedule(@RequestParam("scheduleId") Long scheduleId,
							   @RequestHeader("token") String token) {

		scheduleDeleteService.deleteSchedule(scheduleId, token);
	}

}
