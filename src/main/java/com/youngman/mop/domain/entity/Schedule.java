package com.youngman.mop.domain.entity;

import com.youngman.mop.domain.dto.ScheduleCreateRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Entity
@Table(name = "schedule_tbl")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

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

	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime createTime;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "club_id", nullable = false)
	private Club club;

	@Builder
	public Schedule(String name, String content, String region, String writer, LocalDateTime meetingTime, LocalDateTime createTime, Club club) {
		this.name = name;
		this.content = content;
		this.region = region;
		this.writer = writer;
		this.meetingTime = meetingTime;
		this.createTime = createTime;
		this.club = club;
	}

	public static Schedule of(ScheduleCreateRequestDto scheduleCreateRequestDto, Club club) {
		return Schedule.builder()
				.name(scheduleCreateRequestDto.getName())
				.content(scheduleCreateRequestDto.getContent())
				.region(scheduleCreateRequestDto.getRegion())
				.writer(scheduleCreateRequestDto.getWriter())
				.meetingTime(scheduleCreateRequestDto.getMeetingTime())
				.club(club)
				.build();
	}
}
