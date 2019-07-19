package com.youngman.mop.domain.club.dto;

import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-27.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubPagingResponse {

	private boolean isLast;
	private boolean isEmpty;
	private List<ClubResponse> clubResponses = new ArrayList<>();


	@Builder
	public ClubPagingResponse(boolean isLast, boolean isEmpty, List<ClubResponse> clubResponses) {
		this.isLast = isLast;
		this.isEmpty = isEmpty;
		this.clubResponses = clubResponses;
	}

	public static ClubPagingResponse of(Page<ClubResponse> pagingClubResponse) {
		return ClubPagingResponse.builder()
				.isLast(pagingClubResponse.isLast())
				.isEmpty(pagingClubResponse.isEmpty())
				.clubResponses(pagingClubResponse.getContent())
				.build();
	}
}
