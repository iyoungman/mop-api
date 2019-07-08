package com.youngman.mop.service;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.myclub.dto.MyClubCreateRequest;
import com.youngman.mop.domain.club.dao.ClubRepository;
import com.youngman.mop.domain.member.dao.MemberRepository;
import com.youngman.mop.domain.myclub.dao.MyClubRepository;
import com.youngman.mop.domain.myclub.service.MyClubCreateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by YoungMan on 2019-05-23.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class MyClubServiceTest {

//	@MockBean(name = "myClubRepository")
	@Autowired
	private MyClubRepository myClubRepository;

	@MockBean(name = "memberRepository")
	private MemberRepository memberRepository;

	@MockBean(name = "clubRepository")
	private ClubRepository clubRepository;

	@Autowired
	private MyClubCreateService myClubCreateService;

	@Test
	public void createMyClub() {

		//given
		Member member = Member.builder()
				.build();

		Club club = Club.builder()
				.build();

		given(memberRepository.findByEmail("Test@email.com"))
				.willReturn(Optional.of(member));

		given(clubRepository.findById(1L))
				.willReturn(Optional.of(club));

		MyClubCreateRequest myClubCreateRequest = MyClubCreateRequest.builder()
				.email("Test@email.com")
				.clubId(1L)
				.build();

		//when
		myClubCreateService.createMyClub(myClubCreateRequest);

		//then
		assertThat(myClubRepository.findAll(), is(notNullValue()));
	}
}
