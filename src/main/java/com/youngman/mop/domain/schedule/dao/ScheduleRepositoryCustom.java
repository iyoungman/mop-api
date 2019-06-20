package com.youngman.mop.domain.schedule.dao;

import com.youngman.mop.domain.schedule.domain.Schedule;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ScheduleRepositoryCustom {

	List<Schedule> fetchSchedulesByClubIdAndMonthly(Long clubId);


	//해당 동호회의 가장 최신 일정 가져오기
}
