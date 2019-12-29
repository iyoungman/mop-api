package com.youngman.mop.original.participant.api;

import com.youngman.mop.original.participant.dto.ParticipantCreateRequest;
import com.youngman.mop.original.participant.dto.ParticipantResponse;
import com.youngman.mop.original.participant.service.ParticipantCreateService;
import com.youngman.mop.original.participant.service.ParticipantFetchService;
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

    private final ParticipantCreateService participantCreateService;
    private final ParticipantFetchService participantFetchService;


    @PostMapping
    public int createParticipant(@RequestBody ParticipantCreateRequest participantCreateRequest) {
        return participantCreateService.createParticipant(participantCreateRequest);
    }

    @GetMapping
    public List<ParticipantResponse> fetchParticipants(@RequestParam("scheduleId") Long scheduleId,
                                                       @RequestParam("clubId") Long clubId) {
        return participantFetchService.fetchParticipants(scheduleId, clubId);
    }
}
