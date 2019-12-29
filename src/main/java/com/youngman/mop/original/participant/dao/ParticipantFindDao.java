package com.youngman.mop.original.participant.dao;

import com.youngman.mop.original.participant.domain.Participant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-07-25.
 */

@Service
@RequiredArgsConstructor
public class ParticipantFindDao {

    private final ParticipantRepository participantRepository;

    public List<String> findEmailBySchedule(Long scheduleId) {
        List<Participant> participants = participantRepository.findBySchedule(scheduleId);
        return participants.stream()
                .map(Participant::getEmail)
                .collect(Collectors.toList());
    }

    public int findCountBySchedule(Long scheduleId) {
        List<Participant> participants = participantRepository.findBySchedule(scheduleId);
        return participants.size();
    }

    public boolean isExistByEmailAndSchedule(String email, Long scheduleId) {
        Optional<Participant> participant = participantRepository.findByEmailAndSchedule(email, scheduleId);
        return participant.isPresent();
    }
}
