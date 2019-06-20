package com.youngman.mop.domain.club.dto;

import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-27.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubPagingResponse {

	private boolean isLast;
	private boolean isEmpty;
	private List<MyClubResponse> myClubResponses;


	@Builder
	public ClubPagingResponse(boolean isLast, boolean isEmpty, List<MyClubResponse> myClubResponses) {
		this.isLast = isLast;
		this.isEmpty = isEmpty;
		this.myClubResponses = myClubResponses;
	}

	public static ClubPagingResponse of(Page<MyClubResponse> pagingMyClubResponse) {
		return ClubPagingResponse.builder()
				.isLast(pagingMyClubResponse.isLast())
				.isEmpty(pagingMyClubResponse.isEmpty())
				.myClubResponses(pagingMyClubResponse.getContent())
				.build();
	}
}
