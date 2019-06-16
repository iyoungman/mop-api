package com.youngman.mop.domain.member.service;

import com.youngman.mop.global.error.UserDefineException;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.dto.MemberCreateRequest;
import com.youngman.mop.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-10.
 */

@Service
@RequiredArgsConstructor
public class MemberUpdateService {

	private final MemberRepository memberRepository;

	public void updateMember(MemberCreateRequest memberCreateRequest) {
		Member member = findByEmail(memberCreateRequest.getEmail());
		member.updateMember(memberCreateRequest);
		memberRepository.save(member);
	}

	//이메일은 변경할 수 없다.
	/*private Boolean existMemberByEmail(String email) {

		if(!memberRepository.existsByEmail(email)) {
			throw new UserDeclinedException("존재하지 않는 유저 입니다.");
		}
		return true;
	}*/

	private Member findById(Long id) {
		return memberRepository.findById(id).orElseThrow(
				() -> new UserDefineException("존재하지 않는 아이디 입니다.")
		);
	}

	private Member findByEmail(String email) {
		return memberRepository.findByEmail(email).orElseThrow(
				() -> new UserDefineException("존재하지 않는 유저입니다.")
		);
	}


//findByUUID


	//존재하지 않는 Id 그리고

}
