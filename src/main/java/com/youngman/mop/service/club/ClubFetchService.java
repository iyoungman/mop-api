package com.youngman.mop.service.club;

import com.youngman.mop.model.dto.MyClubResponseDto;
import com.youngman.mop.model.dto.PagingClubResponseDto;
import com.youngman.mop.repository.ClubRepository;
import com.youngman.mop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubFetchService {

	private final ClubRepository clubRepository;
	private final MemberRepository memberRepository;

	public List<MyClubResponseDto> fetchPagingClubsByMember(String email, int pageNo) {
		return clubRepository.fetchPagingClubsByMember(email, findAddressByEmail(email), pageNo);
	}

	public PagingClubResponseDto ff(String email, PageRequest pageable) {
		Page<MyClubResponseDto> pagingMyClubResponseDto =  clubRepository.ff(email, findAddressByEmail(email), pageable);
		return PagingClubResponseDto.of(pagingMyClubResponseDto);
	}

	private String findAddressByEmail(String email) {
		return memberRepository.findByEmail(email).get().getAddress();
	}
}
