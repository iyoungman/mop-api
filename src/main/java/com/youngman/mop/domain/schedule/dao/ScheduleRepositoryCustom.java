package com.youngman.mop.domain.schedule.dao;

import com.youngman.mop.domain.schedule.domain.Schedule;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ScheduleRepositoryCustom {

	List<Schedule> fetchSchedulesByClubIdAndMonthly(Long clubId, LocalDate date);

}
