package com.iyoungman.mop.api.domain.schedule.api;

import com.iyoungman.mop.api.domain.schedule.api.dto.ScheduleCreateRequest;
import com.iyoungman.mop.api.domain.schedule.api.dto.ScheduleUpdateRequest;
import com.iyoungman.mop.api.domain.schedule.application.ScheduleCreateService;
import com.iyoungman.mop.api.domain.schedule.application.ScheduleDeleteService;
import com.iyoungman.mop.api.domain.schedule.application.ScheduleFindService;
import com.iyoungman.mop.api.domain.schedule.application.ScheduleUpdateService;
import com.iyoungman.mop.api.domain.schedule.domain.Schedule;
import java.time.LocalDate;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mop/schedule")
public class ScheduleController {

    private final ScheduleCreateService scheduleCreateService;

    private final ScheduleFindService scheduleFetchService;

    private final ScheduleUpdateService scheduleUpdateService;

    private final ScheduleDeleteService scheduleDeleteService;

    @PostMapping
    public void createSchedule(@RequestBody ScheduleCreateRequest scheduleCreateRequest) {
        scheduleCreateService.createSchedule(scheduleCreateRequest);
    }

    @GetMapping("/monthly")
    public Map<String, Schedule> findSchedulesByClubIdAndMonthly(@RequestParam("clubId") Long clubId,
                                                                  @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") LocalDate date) {
        return scheduleFetchService.findSchedulesByClubIdAndMonthly(clubId, date);
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
