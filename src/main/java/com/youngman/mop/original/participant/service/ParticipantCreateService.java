package com.youngman.mop.original.participant.service;

import com.youngman.mop.original.participant.dao.ParticipantFindDao;
import com.youngman.mop.original.participant.dao.ParticipantRepository;
import com.youngman.mop.original.participant.domain.Participant;
import com.youngman.mop.original.participant.dto.ParticipantCreateRequest;
import com.youngman.mop.original.schedule.dao.ScheduleFindDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-07-25.
 */

@Service
@RequiredArgsConstructor
public class ParticipantCreateService {

    private final ParticipantRepository participantRepository;
    private final ParticipantFindDao participantFindDao;
    private final ScheduleFindDao scheduleFindDao;


    public int createParticipant(ParticipantCreateRequest participantCreateRequest) {
        if (participantFindDao.isExistByEmailAndSchedule(participantCreateRequest.getEmail(), participantCreateRequest.getScheduleId())) {
            return -1;
        }

        Participant participant = Participant.of(participantCreateRequest,
                scheduleFindDao.findById(participantCreateRequest.getScheduleId())
        );
        participantRepository.save(participant);
        return participantFindDao.findCountBySchedule(participantCreateRequest.getScheduleId());
    }
}
