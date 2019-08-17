package com.youngman.mop.domain.participant.service;

import com.youngman.mop.domain.club.dao.ClubRepository;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.participant.dao.ParticipantFindDao;
import com.youngman.mop.domain.participant.dto.ParticipantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YoungMan on 2019-07-25.
 */

@Service
@RequiredArgsConstructor
public class ParticipantFetchService {

    private final ParticipantFindDao participantFindDao;
    private final ClubRepository clubRepository;
    private final ParticipantMapper participantMapper;


    public List<ParticipantResponse> fetchParticipants(Long scheduleId, Long clubId) {
        List<String> participateEmails = participantFindDao.findEmailBySchedule(scheduleId);
        List<Member> allMembers = clubRepository.fetchClubMembers(clubId);
        return checkParticipate(participateEmails, participantMapper.mapFromMembers(allMembers));
    }

    private List<ParticipantResponse> checkParticipate(List<String> participateEmails, List<ParticipantResponse> allMembers) {
        allMembers.stream()
                .filter(p -> participateEmails.contains(p.getEmail()))
                .forEach(p -> p.isParticipate());

        return allMembers;
    }
}
