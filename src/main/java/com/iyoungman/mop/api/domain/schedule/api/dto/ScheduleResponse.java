package com.iyoungman.mop.api.domain.schedule.api.dto;

import com.iyoungman.mop.api.domain.schedule.domain.Schedule;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
