package com.youngman.mop.domain.myclub.service;

import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import com.youngman.mop.domain.myclub.dao.MyClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class MyClubFetchService {

	private final MyClubRepository myClubRepository;

	public List<MyClubResponse> fetchMyClubsByMemberEmail(String email) {
		return myClubRepository.fetchMyClubsByMemberEmail(email);
	}
}
