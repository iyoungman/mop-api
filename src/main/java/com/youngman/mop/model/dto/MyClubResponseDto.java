package com.youngman.mop.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyClubResponseDto {

	private Long id;
	private String name;
	private String introduce;
	private String createDate;
	private String region;
	private String hobby;
	private String upComingMeeting;
	private String upComingMeetingDate;

	@Builder
	public MyClubResponseDto(Long id, String name, String introduce, String createDate, String region, String hobby) {
		this.id = id;
		this.name = name;
		this.introduce = introduce;
		this.createDate = createDate;
		this.region = region;
		this.hobby = hobby;
	}
}
