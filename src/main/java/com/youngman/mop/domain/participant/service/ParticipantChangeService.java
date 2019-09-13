package com.youngman.mop.domain.participant.service;

import com.youngman.mop.domain.participant.dao.ParticipantFindDao;
import com.youngman.mop.domain.participant.dao.ParticipantRepository;
import com.youngman.mop.domain.participant.domain.Participant;
import com.youngman.mop.domain.participant.dto.ParticipantChangeRequest;
import com.youngman.mop.domain.schedule.dao.ScheduleFindDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-07-25.
 */

@Service
@RequiredArgsConstructor
public class ParticipantChangeService {

    private final ParticipantRepository participantRepository;
    private final ParticipantFindDao participantFindDao;
    private final ScheduleFindDao scheduleFindDao;


    public int changeParticipant(ParticipantChangeRequest participantChangeRequest) {
        int participantNum = 0;

        if (participantFindDao.isExistByEmailAndSchedule(participantChangeRequest.getEmail(), participantChangeRequest.getScheduleId())) {
            participantNum = deleteParticipant(participantChangeRequest);
        } else {
            participantNum = createParticipant(participantChangeRequest);
        }

        return participantNum;
    }

    private int createParticipant(ParticipantChangeRequest participantChangeRequest) {
        Participant participant = participantChangeRequest.toEntity(
                scheduleFindDao.findById(participantChangeRequest.getScheduleId())
        );
        participantRepository.save(participant);

        return participantFindDao.findCountBySchedule(participantChangeRequest.getScheduleId());
    }

    private int deleteParticipant(ParticipantChangeRequest participantChangeRequest) {
        Participant participant = participantFindDao.findDeleteParticipant(participantChangeRequest.getEmail(), participantChangeRequest.getScheduleId());
        participantRepository.delete(participant);

        return participantFindDao.findCountBySchedule(participantChangeRequest.getScheduleId());
    }
}
