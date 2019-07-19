package com.youngman.mop.domain.club.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by YoungMan on 2019-07-19.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubResponse {

	private Long clubId;
	private String name;
	private String introduce;
	private LocalDate createDate;
	private String region;
	private String hobby;
	private String imageUri;


	@Builder
	public ClubResponse(Long clubId,
						String name,
						String introduce,
						LocalDate createDate,
						String region,
						String hobby,
						String imageUri) {

		this.clubId = clubId;
		this.name = name;
		this.introduce = introduce;
		this.createDate = createDate;
		this.region = region;
		this.hobby = hobby;
		this.imageUri = imageUri;
	}
}
