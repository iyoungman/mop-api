package com.youngman.mop.controller;

import com.youngman.mop.domain.dto.ScheduleCreateRequestDto;
import com.youngman.mop.service.schedule.ScheduleCreateService;
import com.youngman.mop.service.schedule.ScheduleDeleteService;
import com.youngman.mop.service.schedule.ScheduleFetchService;
import com.youngman.mop.service.schedule.ScheduleUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YoungMan on 2019-05-24.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/mop/schedule")
public class ScheduleController {

	private final ScheduleCreateService scheduleCreateService;
	private final ScheduleFetchService scheduleFetchService;
	private final ScheduleUpdateService scheduleUpdateService;
	private final ScheduleDeleteService scheduleDeleteService;


	@PostMapping
	public void createSchedule(@RequestBody ScheduleCreateRequestDto scheduleCreateRequestDto) {
		scheduleCreateService.createSchedule(scheduleCreateRequestDto);
	}

	@GetMapping
	public void ff() {
	}

	@PutMapping
	public void updateSchedule() {
	}

	@DeleteMapping
	public void deleteSchedule() {
	}

}
