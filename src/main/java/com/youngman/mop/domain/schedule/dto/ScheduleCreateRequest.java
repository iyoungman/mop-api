package com.youngman.mop.domain.schedule.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleCreateRequest {

	private String name;
	private String content;
	private String region;
	private String writer;
	private LocalDateTime meetingTime;
	private Long clubId;


	@Builder
	public ScheduleCreateRequest(String name, String content, String region,
								 LocalDateTime meetingTime, String writer, Long clubId) {
		this.name = name;
		this.content = content;
		this.region = region;
		this.meetingTime = meetingTime;
		this.writer = writer;
		this.clubId = clubId;
	}
}
