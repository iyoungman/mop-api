package com.youngman.mop.controller;

import com.youngman.mop.model.dto.MemberSignInRequestDto;
import com.youngman.mop.model.dto.MemberCreateRequestDto;
import com.youngman.mop.service.member.MemberCreateService;
import com.youngman.mop.service.member.MemberDeleteService;
import com.youngman.mop.service.member.MemberSignInService;
import com.youngman.mop.service.member.MemberUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YoungMan on 2019-05-24.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mop/member")
public class MemberController {

	private final MemberSignInService memberSignInService;
	private final MemberCreateService memberCreateService;
	private final MemberUpdateService memberUpdateService;
	private final MemberDeleteService memberDeleteService;


	@PostMapping("/signin")
	public Boolean signIn(@RequestBody MemberSignInRequestDto memberSignInRequestDto) {
		return memberSignInService.singIn(memberSignInRequestDto);
	}

	@PostMapping
	public void createMember(@RequestBody MemberCreateRequestDto memberCreateRequestDto) {
		memberCreateService.createMember(memberCreateRequestDto);
	}

	@PutMapping
	public void updateMember(@RequestBody MemberCreateRequestDto memberCreateRequestDto) {
		memberUpdateService.updateMember(memberCreateRequestDto);
	}

	@DeleteMapping
	public void deleteMember(@RequestParam("email") String email) {
		memberDeleteService.deleteByEmail(email);
	}
}
