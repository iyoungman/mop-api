package com.youngman.mop.service.member;

import com.youngman.mop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
@RequiredArgsConstructor
public class MemberDeleteService {

	private final MemberRepository memberRepository;

	public void deleteById(Long id) {
		memberRepository.deleteById(id);
	}

	public void deleteByEmail(String email) {
		memberRepository.deleteByEmail(email);
	}
}
