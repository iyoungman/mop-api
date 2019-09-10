package com.youngman.mop.domain.schedule.dto;

import com.youngman.mop.domain.schedule.domain.Schedule;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by YoungMan on 2019-07-08.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleResponse {

    private Long id;
    private String name;
    private String content;
    private String region;
    private String writer;
    private String meetingTime;
    private boolean isParticipate;

    @Builder
    public ScheduleResponse(Long id, String name, String content, String region,
                            String writer, String meetingTime, boolean isParticipate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.region = region;
        this.writer = writer;
        this.meetingTime = meetingTime;
        this.isParticipate = isParticipate;
    }

    public static ScheduleResponse of(Schedule schedule) {
        return ScheduleResponse.builder()
                .id(schedule.getId())
                .name(schedule.getName())
                .content(schedule.getContent())
                .region(schedule.getRegion())
                .writer(schedule.getWriter())
                .meetingTime(schedule.getMeetingTime().toString())
                .build();
    }

    public String getMeetingDateStr() {
        String[] split = meetingTime.split("T");
        return split[0];
    }

    public void updateParticipate() {
        this.isParticipate = true;
    }

}
