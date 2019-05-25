package com.youngman.mop.service.myclub;

import com.youngman.mop.model.dto.MyClubResponseDto;
import com.youngman.mop.repository.MyClubRepository;
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

	public List<MyClubResponseDto> fetchMyClubsByMemberEmail(String email) {
		return myClubRepository.fetchMyClubsByMemberEmail(email);
	}
}
