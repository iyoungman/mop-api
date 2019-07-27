package com.youngman.mop.domain.participant.service;

import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.participant.domain.Participant;
import com.youngman.mop.domain.participant.dto.ParticipantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-07-26.
 */

@Service
@RequiredArgsConstructor
public class ParticipantMapper {

	public List<ParticipantResponse> mapFromParticipants(List<Participant> participants) {
		return participants.stream()
				.map(ParticipantResponse::ofParticipant)
				.collect(Collectors.toList());
	}

	public List<ParticipantResponse> mapFromMembers(List<Member> members) {
		return members.stream()
				.map(ParticipantResponse::ofMember)
				.collect(Collectors.toList());
	}
}
