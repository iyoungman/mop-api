package com.youngman.mop.service.member;

import com.youngman.mop.model.Member;
import com.youngman.mop.model.dto.MemberDto;
import com.youngman.mop.repository.MemberRepository;
import lombok.Builder;

/**
 * Created by YoungMan on 2019-05-10.
 */

public class MemberUpdateService {

	private final MemberRepository memberRepository;
	private final MemberFindService memberFindService;

	@Builder
	public MemberUpdateService(MemberRepository memberRepository, MemberFindService memberFindService) {
		this.memberRepository = memberRepository;
		this.memberFindService = memberFindService;
	}

	public void updateMember(MemberDto.SignUpRequest signUpRequest) {
		Member member = memberFindService.findById(signUpRequest.getId());
		member.updateMember(signUpRequest);

		if(!memberFindService.existMemberById(member.getId())) {
			memberRepository.save(member);
		}
	}

}
