package com.youngman.mop.service;

import com.youngman.mop.domain.club.dto.ClubCreateRequest;
import com.youngman.mop.domain.club.dao.ClubRepository;
import com.youngman.mop.domain.club.service.ClubCreateService;
import org.junit.Test;
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
public class ClubServiceTest {

	@Autowired
	private ClubRepository clubRepository;

	@Autowired
	private ClubCreateService clubCreateService;

	@Test
	public void createClub() throws Exception {

		//given
		ClubCreateRequest clubCreateRequest = ClubCreateRequest.builder()
				.name("동호회2")
				.hobby("볼링")
				.introduce("한게임 해요")
				.region("부산")
				.build();

		//when
		clubCreateService.createClub(clubCreateRequest);

		//then

	}
}
