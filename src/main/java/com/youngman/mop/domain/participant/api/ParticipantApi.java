package com.youngman.mop.domain.participant.api;

import com.youngman.mop.domain.participant.dto.ParticipantChangeRequest;
import com.youngman.mop.domain.participant.dto.ParticipantResponse;
import com.youngman.mop.domain.participant.service.ParticipantChangeService;
import com.youngman.mop.domain.participant.service.ParticipantFetchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YoungMan on 2019-07-25.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mop/participant")
public class ParticipantApi {

    private final ParticipantChangeService participantChangeService;
    private final ParticipantFetchService participantFetchService;


    @PostMapping
    public int changeParticipant(@RequestBody ParticipantChangeRequest participantChangeRequest) {
        return participantChangeService.changeParticipant(participantChangeRequest);
    }

    @GetMapping
    public List<ParticipantResponse> fetchParticipants(@RequestParam("scheduleId") Long scheduleId,
                                                       @RequestParam("clubId") Long clubId) {
        return participantFetchService.fetchParticipants(scheduleId, clubId);
    }

    @GetMapping("/count")
    public int fetchParticipantCount(@RequestParam("scheduleId") Long scheduleId) {
        return participantFetchService.fetchParticipantCount(scheduleId);
    }
}
