package com.youngman.mop.domain.participant.domain;

import com.youngman.mop.domain.participant.dto.ParticipantCreateRequest;
import com.youngman.mop.domain.schedule.domain.Schedule;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by YoungMan on 2019-07-25.
 */

@Entity
@Table(name = "participant_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Participant {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "participant_id")
	private Long id;

	private String email;

	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id", nullable = false)
	private Schedule schedule;


	@Builder
	public Participant(String email, String name, Schedule schedule) {
		this.email = email;
		this.name = name;
		this.schedule = schedule;
	}

	public static Participant of(ParticipantCreateRequest participantCreateRequest, Schedule schedule) {
		return Participant.builder()
				.email(participantCreateRequest.getEmail())
				.name(participantCreateRequest.getName())
				.schedule(schedule)
				.build();
	}
}
