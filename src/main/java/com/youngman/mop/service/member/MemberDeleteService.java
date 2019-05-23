package com.youngman.mop.service.member;

import com.youngman.mop.repository.MemberRepository;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
public class MemberDeleteService {

	private final MemberRepository memberRepository;

	public MemberDeleteService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void deleteById(Long id) {
		memberRepository.deleteById(id);
	}
}
