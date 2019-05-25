package com.youngman.mop.controller;

import com.youngman.mop.model.dto.MyClubCreateRequestDto;
import com.youngman.mop.model.dto.MyClubResponseDto;
import com.youngman.mop.service.myclub.MyClubCreateService;
import com.youngman.mop.service.myclub.MyClubDeleteService;
import com.youngman.mop.service.myclub.MyClubFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-24.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mop/myclub")
public class MyClubController {

	private final MyClubCreateService myClubCreateService;
	private final MyClubFetchService myClubFetchService;
	private final MyClubDeleteService myClubDeleteService;

	@PostMapping
	public void createMyClub(MyClubCreateRequestDto myClubCreateRequestDto) {
		myClubCreateService.createMyClub(myClubCreateRequestDto);
	}

	@GetMapping
	public List<MyClubResponseDto> fetchMyClubsByMemberEmail(@RequestParam("email") String email) {
		return myClubFetchService.fetchMyClubsByMemberEmail(email);
	}

	@DeleteMapping
	public void deleteMyClub(@RequestParam("email") String email, @RequestParam("clubId") Long clubId) {
		myClubDeleteService.deleteMyClub(email, clubId);
	}

}
