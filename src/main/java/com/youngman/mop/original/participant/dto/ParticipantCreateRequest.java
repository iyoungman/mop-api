package com.youngman.mop.original.participant.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-07-25.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParticipantCreateRequest {

	private Long scheduleId;
	private String email;
	private String name;
}
