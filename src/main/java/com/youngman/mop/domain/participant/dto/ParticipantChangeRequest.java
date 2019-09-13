package com.youngman.mop.domain.participant.dto;

import com.youngman.mop.domain.participant.domain.Participant;
import com.youngman.mop.domain.schedule.domain.Schedule;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-07-25.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParticipantChangeRequest {

	private Long scheduleId;
	private String email;
	private String name;

	@Builder
	public ParticipantChangeRequest(Long scheduleId, String email, String name) {
		this.scheduleId = scheduleId;
		this.email = email;
		this.name = name;
	}

	public Participant toEntity(Schedule schedule) {
		return Participant.builder()
				.schedule(schedule)
				.email(email)
				.name(name)
				.build();
	}
}
