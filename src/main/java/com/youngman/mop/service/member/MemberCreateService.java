package com.youngman.mop.service.member;

import com.youngman.mop.model.Member;
import com.youngman.mop.model.dto.MemberDto;
import com.youngman.mop.repository.MemberRepository;

/**
 * Created by YoungMan on 2019-05-10.
 */

public class MemberCreateService {

	private final MemberRepository memberRepository;
	private final MemberFindService memberFindService;

	public MemberCreateService(MemberRepository memberRepository, MemberFindService memberFindService) {
		this.memberRepository = memberRepository;
		this.memberFindService = memberFindService;
	}

	public void signUp(MemberDto.SignUpRequest signUpRequest) {

		if (!memberFindService.existMemberById(signUpRequest.getId())) {
			memberRepository.save(Member.of(signUpRequest));
		}
	}


}
