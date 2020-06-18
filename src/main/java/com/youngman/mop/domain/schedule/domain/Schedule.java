package com.youngman.mop.domain.schedule.domain;

import com.youngman.mop.common.model.Address;
import com.youngman.mop.common.model.BaseTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Entity
@Table(name = "schedule_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @Column(name = "club_id")
    private Long clubId;

    private String name;

    @Lob
    private String content;

    @Embedded
    private Address address;

    @Embedded
    private Writer writer;

    @Embedded
    private MeetingTime meetingTime;

    @Builder
    public Schedule(Long clubId, String name, String content,
            Address address, Writer writer, MeetingTime meetingTime) {
        this.clubId = clubId;
        this.name = name;
        this.content = content;
        this.address = address;
        this.writer = writer;
        this.meetingTime = meetingTime;
    }
}
