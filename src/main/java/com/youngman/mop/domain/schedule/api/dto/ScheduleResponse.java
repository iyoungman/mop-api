package com.youngman.mop.domain.schedule.api.dto;

import com.youngman.mop.domain.schedule.domain.Schedule;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YoungMan on 2019-07-08.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleResponse {

	private Map<String, Schedule> scheduleMap = new HashMap<>();


	@Builder
	public ScheduleResponse(Map<String, Schedule> scheduleMap) {
		this.scheduleMap = scheduleMap;
	}
}
