package com.youngman.mop.original.participant.dao;

import com.youngman.mop.original.participant.dto.ParticipantResponse;

import java.util.List;

/**
 * Created by YoungMan on 2019-07-26.
 */

public interface ParticipantRepositoryCustom {

    List<ParticipantResponse> fetchParticipants(Long clubId);
}
