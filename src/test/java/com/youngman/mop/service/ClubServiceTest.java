package com.youngman.mop.service;

import com.youngman.mop.domain.dto.ClubCreateRequestDto;
import com.youngman.mop.repository.ClubRepository;
import com.youngman.mop.service.club.ClubCreateService;
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
		ClubCreateRequestDto clubCreateRequestDto = ClubCreateRequestDto.builder()
				.name("동호회2")
				.hobby("볼링")
				.introduce("한게임 해요")
				.region("부산")
				.build();

		//when
		clubCreateService.createClub(clubCreateRequestDto);

		//then

	}
}
