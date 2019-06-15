package com.youngman.mop.controller;

import com.youngman.mop.domain.dto.ClubCreateRequestDto;
import com.youngman.mop.domain.dto.ClubInfoResponseDto;
import com.youngman.mop.domain.dto.PagingClubResponseDto;
import com.youngman.mop.service.club.ClubCreateService;
import com.youngman.mop.service.club.ClubDeleteService;
import com.youngman.mop.service.club.ClubFetchService;
import com.youngman.mop.service.club.ClubUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
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
	public PagingClubResponseDto fetchPagingClubsByMember(@RequestParam("email") String email,
														  @RequestParam("pageNo") int pageNo) {

		return clubFetchService.fetchPagingClubsByMember(email, PageRequest.of(pageNo - 1, 24));
	}

	@GetMapping("/info")
	public ClubInfoResponseDto fetchClubInfoById(@RequestParam("clubId") Long clubId) {
		log.info("clubId => {}", clubId);
		return clubFetchService.fetchClubInfoById(clubId);
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
