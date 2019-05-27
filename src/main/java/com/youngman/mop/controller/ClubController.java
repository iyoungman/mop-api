package com.youngman.mop.controller;

import com.youngman.mop.model.common.PageRequest;
import com.youngman.mop.model.dto.ClubCreateRequestDto;
import com.youngman.mop.model.dto.MyClubResponseDto;
import com.youngman.mop.model.dto.PagingClubResponseDto;
import com.youngman.mop.service.club.ClubCreateService;
import com.youngman.mop.service.club.ClubDeleteService;
import com.youngman.mop.service.club.ClubFetchService;
import com.youngman.mop.service.club.ClubUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-24.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/mop/club")
public class ClubController {

	private final ClubCreateService clubCreateService;
	private final ClubFetchService clubFetchService;
	private final ClubUpdateService clubUpdateService;
	private final ClubDeleteService clubDeleteService;


	@PostMapping
	public void createClub(@RequestBody ClubCreateRequestDto clubCreateRequestDto) {
		clubCreateService.createClub(clubCreateRequestDto);
	}

	@GetMapping("/member")
	public List<MyClubResponseDto> fetchPagingClubsByMember(@RequestParam("email") String email,
															@RequestParam("pageNo") int pageNo) {
		return clubFetchService.fetchPagingClubsByMember(email, pageNo);
	}


	@GetMapping("/test")
	public PagingClubResponseDto ff(@RequestParam("email") String email,
									@RequestParam("pageNo") int pageNo) {

		return clubFetchService.ff(email, PageRequest.of(pageNo, 24));
	}


	@PutMapping
	public void updateClub(@RequestBody ClubCreateRequestDto clubCreateRequestDto) {
		clubUpdateService.updateClub(clubCreateRequestDto);
	}

	@DeleteMapping
	public void deleteClub(@RequestParam("id") Long id) {
		clubDeleteService.deleteClub(id);
	}

}
