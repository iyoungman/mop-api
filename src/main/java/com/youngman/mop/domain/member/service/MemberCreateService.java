package com.youngman.mop.domain.member.service;

import com.youngman.mop.domain.member.exception.EmailDuplicationException;
import com.youngman.mop.global.error.UserDefineException;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.dto.MemberCreateRequest;
import com.youngman.mop.domain.member.repository.MemberRepository;
import com.youngman.mop.global.error.exception.ErrorCodeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
@RequiredArgsConstructor
public class MemberCreateService {

	private final MemberRepository memberRepository;


	public void createMember(MemberCreateRequest memberCreateRequest) {

		if (!memberRepository.existsByEmail(memberCreateRequest.getEmail())) {
			memberRepository.save(Member.of(memberCreateRequest));
			return;
		}
		throw new EmailDuplicationException();
	}

}
