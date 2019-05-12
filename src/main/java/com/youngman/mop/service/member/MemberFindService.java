package com.youngman.mop.service.member;

import com.youngman.mop.exception.UserDefineException;
import com.youngman.mop.model.Member;
import com.youngman.mop.repository.MemberRepository;

/**
 * Created by YoungMan on 2019-05-10.
 */

public class MemberFindService {

	private final MemberRepository memberRepository;

	public MemberFindService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Member findById(String id) {
		return memberRepository.findById(id).orElseThrow(
				() -> new UserDefineException("")
		);
	}

	public Boolean existMemberById(String id) {

		if (memberRepository.existsById(id)) {
			throw new Exception("중복된 아이디입니다.");
		}
		return false;
	}
}
