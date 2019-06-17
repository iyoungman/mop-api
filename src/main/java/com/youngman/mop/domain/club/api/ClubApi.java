package com.youngman.mop.domain.club.api;

import com.youngman.mop.domain.club.dto.ClubCreateRequest;
import com.youngman.mop.domain.club.dto.ClubInfoResponse;
import com.youngman.mop.domain.club.dto.ClubPagingResponse;
import com.youngman.mop.domain.club.service.ClubCreateService;
import com.youngman.mop.domain.club.service.ClubDeleteService;
import com.youngman.mop.domain.club.service.ClubFetchService;
import com.youngman.mop.domain.club.service.ClubUpdateService;
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
public class ClubApi {

	private final ClubCreateService clubCreateService;
	private final ClubFetchService clubFetchService;
	private final ClubUpdateService clubUpdateService;
	private final ClubDeleteService clubDeleteService;


	@PostMapping
	public void createClub(@RequestBody ClubCreateRequest clubCreateRequest) {
		clubCreateService.createClub(clubCreateRequest);
	}

	@GetMapping("/member")
	public ClubPagingResponse fetchPagingClubsByMember(@RequestParam("email") String email,
													   @RequestParam("pageNo") int pageNo) {

		return clubFetchService.fetchPagingClubsByMember(email, PageRequest.of(pageNo - 1, 24));
	}

	@GetMapping("/info")
	public ClubInfoResponse fetchClubInfoById(@RequestParam("clubId") Long clubId) {
		return clubFetchService.fetchClubInfoById(clubId);
	}

	@PutMapping
	public void updateClub(@RequestBody ClubCreateRequest clubCreateRequest) {
		clubUpdateService.updateClub(clubCreateRequest);
	}

	@DeleteMapping
	public void deleteClub(@RequestParam("id") Long id) {
		clubDeleteService.deleteClub(id);
	}

}
