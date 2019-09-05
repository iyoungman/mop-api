package com.youngman.mop.domain.schedule.service;

import com.youngman.mop.domain.participant.dao.ParticipantFindDao;
import com.youngman.mop.domain.participant.dao.ParticipantRepository;
import com.youngman.mop.domain.schedule.dao.ScheduleRepository;
import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.domain.schedule.dto.ScheduleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ScheduleFetchService {

    private final ScheduleRepository scheduleRepository;
    private final ParticipantFindDao participantFindDao;
    private final ScheduleMapper scheduleMapper;

    public Map<String, ScheduleResponse> fetchSchedulesByClubIdAndMonthly(Long clubId, String email, LocalDate date) {
        List<Schedule> schedules = scheduleRepository.fetchSchedulesByClubIdAndMonthly(clubId, date);
        List<Long> participateScheduleIds = participantFindDao.findScheduleIdByEmail(email);

        List<ScheduleResponse> scheduleResponses = checkParticipate(scheduleMapper.mapFrom(schedules), participateScheduleIds);
        return scheduleMapper.convertListToMap(scheduleResponses);
    }

    private List<ScheduleResponse> checkParticipate(List<ScheduleResponse> scheduleResponses, List<Long> participateScheduleIds) {
        for (ScheduleResponse scheduleResponse : scheduleResponses) {
            if (participateScheduleIds.contains(scheduleResponse.getId())) {
                scheduleResponse.updateParticipate();
            }
        }

        return scheduleResponses;
    }


}
