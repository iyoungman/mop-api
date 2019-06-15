package com.youngman.mop.domain.dto;

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
public class PagingClubResponseDto {

	private boolean isLast;
	private boolean isEmpty;
	private List<MyClubResponseDto> myClubResponseDtos;


	@Builder
	public PagingClubResponseDto(boolean isLast, boolean isEmpty, List<MyClubResponseDto> myClubResponseDtos) {
		this.isLast = isLast;
		this.isEmpty = isEmpty;
		this.myClubResponseDtos = myClubResponseDtos;
	}

	public static PagingClubResponseDto of(Page<MyClubResponseDto> pagingMyClubResponseDto) {
		return PagingClubResponseDto.builder()
				.isLast(pagingMyClubResponseDto.isLast())
				.isEmpty(pagingMyClubResponseDto.isEmpty())
				.myClubResponseDtos(pagingMyClubResponseDto.getContent())
				.build();
	}
}
