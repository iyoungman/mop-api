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
public class MemberUpdateService {

	private final MemberRepository memberRepository;

	public void updateMember(MemberCreateRequestDto memberCreateRequestDto) {
		Member member = findByEmail(memberCreateRequestDto.getEmail());
		member.updateMember(memberCreateRequestDto);
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
