package com.youngman.mop.domain.schedule.domain;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.model.BaseTime;
import com.youngman.mop.domain.schedule.dto.ScheduleCreateRequest;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseTime {

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

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "club_id", nullable = false)
	private Club club;

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
}
