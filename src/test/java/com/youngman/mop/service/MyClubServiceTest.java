package com.youngman.mop.service;

import com.youngman.mop.model.dto.MyClubCreateRequestDto;
import com.youngman.mop.repository.MyClubRepository;
import com.youngman.mop.service.myclub.MyClubCreateService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by YoungMan on 2019-05-23.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MyClubServiceTest {

	@Autowired
	private MyClubRepository myClubRepository;

	@Autowired
	private MyClubCreateService myClubCreateService;

	public void createMyClub() throws Exception {
		MyClubCreateRequestDto myClubCreateRequestDto = MyClubCreateRequestDto.builder()
				.email("Test@email.com")
				.clubId()
				.build()
		;

		myClubCreateService.createMyClub();
	}
}
