package com.youngman.mop.domain.schedule.api.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by YoungMan on 2019-06-20.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleUpdateRequest {

    private Long scheduleId;
    private String name;
    private String content;
    private String region;
    private String writer;
    private LocalDateTime meetingTime;


    @Builder
    public ScheduleUpdateRequest(Long scheduleId, String name, String content,
                                 String region, String writer, LocalDateTime meetingTime) {
        this.scheduleId = scheduleId;
        this.name = name;
        this.content = content;
        this.region = region;
        this.writer = writer;
        this.meetingTime = meetingTime;
    }
}
