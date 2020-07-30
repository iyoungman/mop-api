package com.iyoungman.mop.api.domain.myclub.application;

import com.iyoungman.mop.api.domain.myclub.domain.MyClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2019-05-13.
 */

@Service
@RequiredArgsConstructor
public class MyClubDeleteService {

	private final MyClubRepository myClubRepository;

	@Transactional
	public void deleteMyClub(Long memberId, Long clubId) {
		myClubRepository.deleteByMemberIdAndClubId(memberId, clubId);
	}
}
