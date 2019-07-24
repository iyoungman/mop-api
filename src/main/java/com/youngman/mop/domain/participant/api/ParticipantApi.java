package com.youngman.mop.domain.participant.api;

import com.youngman.mop.domain.participant.domain.Participant;
import com.youngman.mop.domain.participant.dto.ParticipantCreateRequest;
import com.youngman.mop.domain.participant.service.ParticipantCreateService;
import com.youngman.mop.domain.schedule.dto.ScheduleCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YoungMan on 2019-07-25.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mop/participant")
public class ParticipantApi {

	private final ParticipantCreateService participantCreateService;


	@PostMapping
	public int createParticipant(@RequestBody ParticipantCreateRequest participantCreateRequest) {
		return participantCreateService.createParticipant(participantCreateRequest);
	}
}
