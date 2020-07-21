package com.youngman.mop.domain.schedule.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.youngman.mop.common.model.Address;
import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.domain.schedule.domain.Writer;
import com.youngman.mop.domain.schedule.exception.InvalidMeetingTimeException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.function.Predicate;

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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
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

	//TODO 도메인 수정
	public Schedule toEntity() {
		return Schedule.builder()
				.name(name)
				.content(content)
				.address(new Address(region, region, region))
				.writer(new Writer(1L, writer))
				.meetingTime(meetingTime)
				.clubId(clubId)
				.build();
	}

	public void timeValidationCheck() {
		Predicate<LocalDateTime> predicate = time -> time.isAfter(LocalDateTime.now());
		if (!predicate.test(meetingTime)) {
			throw new InvalidMeetingTimeException();
		}
	}
}
