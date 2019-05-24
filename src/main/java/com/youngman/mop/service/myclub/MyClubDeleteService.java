package com.youngman.mop.service.myclub;

import com.youngman.mop.repository.MyClubRepository;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-13.
 */

@Service
public class MyClubDeleteService {

	private final MyClubRepository myClubRepository;

	public MyClubDeleteService(MyClubRepository myClubRepository) {
		this.myClubRepository = myClubRepository;
	}

	public void deleteMyClub(Long id) {
		myClubRepository.deleteById(id);
	}
}
