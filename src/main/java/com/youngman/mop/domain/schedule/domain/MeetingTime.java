package com.youngman.mop.domain.schedule.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by YoungMan on 2019-12-23.
 */

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MeetingTime {

	@Column(name = "meeting_date")
	private LocalDate meetingDate;

	@Column(name = "meeting_time")
	private LocalTime meetingTime;
}
