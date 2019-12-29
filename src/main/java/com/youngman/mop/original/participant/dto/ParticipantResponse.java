package com.youngman.mop.original.participant.dto;

import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.original.participant.domain.Participant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-07-26.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParticipantResponse {

    private String name;
    private String email;
    private Boolean isParticipate = false;

    @Builder
    public ParticipantResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static ParticipantResponse ofParticipant(Participant participant) {
        return ParticipantResponse.builder()
                .email(participant.getEmail())
                .name(participant.getName())
                .build();
    }

    public static ParticipantResponse ofMember(Member member) {
        return ParticipantResponse.builder()
                .email(member.getEmail())
                .name(member.getName())
                .build();
    }

    public void isParticipate() {
        isParticipate = true;
    }
}
