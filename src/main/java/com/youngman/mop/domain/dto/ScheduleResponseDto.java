package com.youngman.mop.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by YoungMan on 2019-05-25.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleResponseDto {

	private Long id;
	private String name;
	private String content;
	private String region;
	private String writer;
	private LocalDateTime meetingTime;

	@Builder
	public ScheduleResponseDto(Long id, String name, String content,
							   String region, String writer, LocalDateTime meetingTime) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.region = region;
		this.writer = writer;
		this.meetingTime = meetingTime;
	}
}
