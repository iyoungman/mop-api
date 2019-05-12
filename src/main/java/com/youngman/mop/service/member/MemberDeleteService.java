package com.youngman.mop.service.member;

import com.youngman.mop.repository.MemberRepository;

/**
 * Created by YoungMan on 2019-05-10.
 */

public class MemberDeleteService {

	private final MemberRepository memberRepository;

	public MemberDeleteService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void deleteById(String id) {
		memberRepository.deleteById(id);
	}
}
