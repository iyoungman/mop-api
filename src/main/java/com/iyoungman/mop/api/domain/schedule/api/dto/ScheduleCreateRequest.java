package com.iyoungman.mop.api.domain.schedule.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iyoungman.mop.api.common.model.Address;
import com.iyoungman.mop.api.common.model.Writer;
import com.iyoungman.mop.api.domain.schedule.domain.Schedule;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleCreateRequest {

    private String name;

    private String content;

    private String region;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime meetingTime;

    private Long clubId;

    private Long memberId;

    private String memberName;

    public ScheduleCreateRequest(String name, String content, String region, LocalDateTime meetingTime,
            Long clubId, Long memberId, String memberName) {
        this.name = name;
        this.content = content;
        this.region = region;
        this.meetingTime = meetingTime;
        this.clubId = clubId;
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public Schedule toEntity() {
        return Schedule.builder()
                .name(name)
                .content(content)
                .address(toAddress())
                .writer(toWriter())
                .meetingTime(meetingTime)
                .clubId(clubId)
                .build();
    }

    private Address toAddress() {
        return new Address(region, region, region);
    }

    private Writer toWriter() {
        return new Writer(memberId, memberName);
    }
}
