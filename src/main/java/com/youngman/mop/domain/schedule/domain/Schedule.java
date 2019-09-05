package com.youngman.mop.domain.schedule.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youngman.mop.club.domain.Club;
import com.youngman.mop.domain.generic.time.BaseTime;
import com.youngman.mop.domain.participant.domain.Participant;
import com.youngman.mop.domain.schedule.dto.ScheduleCreateRequest;
import com.youngman.mop.domain.schedule.dto.ScheduleUpdateRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Entity
@Table(name = "schedule_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseTime implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    private String name;

    @Lob
    private String content;

    private String region;

    private String writer;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime meetingTime;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @JsonIgnore
    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
    private List<Participant> participants = new ArrayList<>();

    @Builder
    public Schedule(String name, String content, String region,
                    String writer, LocalDateTime meetingTime, Club club) {
        this.name = name;
        this.content = content;
        this.region = region;
        this.writer = writer;
        this.meetingTime = meetingTime;
        this.club = club;
    }

    public static Schedule of(ScheduleCreateRequest scheduleCreateRequest, Club club) {
        return Schedule.builder()
                .name(scheduleCreateRequest.getName())
                .content(scheduleCreateRequest.getContent())
                .region(scheduleCreateRequest.getRegion())
                .writer(scheduleCreateRequest.getWriter())
                .meetingTime(scheduleCreateRequest.getMeetingTime())
                .club(club)
                .build();
    }

    public void updateSchedule(ScheduleUpdateRequest scheduleUpdateRequest) {
        this.name = scheduleUpdateRequest.getName();
        this.content = scheduleUpdateRequest.getContent();
        this.region = scheduleUpdateRequest.getRegion();
        this.writer = scheduleUpdateRequest.getWriter();
        this.meetingTime = scheduleUpdateRequest.getMeetingTime();
    }
}
