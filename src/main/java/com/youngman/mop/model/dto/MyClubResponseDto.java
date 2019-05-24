package com.youngman.mop.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyClubResponseDto {

	private Long id;
	private String name;
	private String introduce;
	private LocalDate createDate;
	private String region;
	private String hobby;
	private String upComingMeetingName;
	private LocalDateTime upComingMeetingDate;

	@Builder
	public MyClubResponseDto(Long id,
							 String name,
							 String introduce,
							 LocalDate createDate,
							 String region,
							 String hobby,
							 String upComingMeetingName,
							 LocalDateTime upComingMeetingDate) {
		this.id = id;
		this.name = name;
		this.introduce = introduce;
		this.createDate = createDate;
		this.region = region;
		this.hobby = hobby;
		this.upComingMeetingName = upComingMeetingName;
		this.upComingMeetingDate = upComingMeetingDate;
	}
}
