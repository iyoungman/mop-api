package com.youngman.mop.domain.club.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-30.
 */

@Getter
@NoArgsConstructor
public class ClubInfoResponse implements Serializable {

	private ClubDto clubDto;
	private List<MemberDto> memberDtos = new ArrayList<>();


	@Builder
	public ClubInfoResponse(ClubDto clubDto, List<MemberDto> memberDtos) {
		this.clubDto = clubDto;
		this.memberDtos = memberDtos;
	}


	@Getter
	@Setter
	@NoArgsConstructor
	public static class ClubDto implements Serializable {
		private Long clubId;
		private String name;
		private String introduce;
		private LocalDate createDate;
		private String region;
		private String hobby;
		private LocalDateTime upComingMeetingDate;

		@Builder
		public ClubDto(Long clubId, String name, String introduce, LocalDate createDate,
					   String region, String hobby, LocalDateTime upComingMeetingDate) {
			this.clubId = clubId;
			this.name = name;
			this.introduce = introduce;
			this.createDate = createDate;
			this.region = region;
			this.hobby = hobby;
			this.upComingMeetingDate = upComingMeetingDate;
		}
	}


	@Getter
	@Setter
	@NoArgsConstructor
	public static class MemberDto implements Serializable {
		private String email;
		private String name;
		private String mobile;
		private String hobby;
		private String introduce;

		@Builder
		public MemberDto(String email, String name, String mobile, String hobby, String introduce) {
			this.email = email;
			this.name = name;
			this.mobile = mobile;
			this.hobby = hobby;
			this.introduce = introduce;
		}
	}

}
