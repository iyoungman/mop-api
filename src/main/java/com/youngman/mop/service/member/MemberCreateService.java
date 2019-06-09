package com.youngman.mop.service.member;

import com.youngman.mop.exception.UserDefineException;
import com.youngman.mop.domain.entity.Member;
import com.youngman.mop.domain.dto.MemberCreateRequestDto;
import com.youngman.mop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
@RequiredArgsConstructor
public class MemberCreateService {

	private final MemberRepository memberRepository;

	public void createMember(MemberCreateRequestDto memberCreateRequestDto) {

		if (!memberRepository.existsByEmail(memberCreateRequestDto.getEmail())) {
			memberRepository.save(Member.of(memberCreateRequestDto));
			return;
		}
		throw new UserDefineException("이미 존재하는 이메일 입니다.");
	}

}
