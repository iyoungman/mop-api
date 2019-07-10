//package com.youngman.mop.domain.myclub.service;
//
//import com.youngman.mop.domain.club.dao.ClubFindDao;
//import com.youngman.mop.domain.club.domain.Club;
//import com.youngman.mop.domain.member.dao.MemberFindDao;
//import com.youngman.mop.domain.member.domain.Member;
//import com.youngman.mop.domain.myclub.dto.MyClubCreateRequest;
//import com.youngman.mop.domain.club.dao.ClubRepository;
//import com.youngman.mop.domain.member.dao.MemberRepository;
//import com.youngman.mop.domain.myclub.dao.MyClubRepository;
//import com.youngman.mop.domain.myclub.service.MyClubCreateService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.transaction.Transactional;
//
//import java.util.Optional;
//
//import static org.hamcrest.core.Is.is;
//import static org.hamcrest.core.IsNull.notNullValue;
//import static org.junit.Assert.assertThat;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.BDDMockito.given;
//
///**
// * Created by YoungMan on 2019-05-23.
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class MyClubCreateServiceTest {
//
//	@MockBean(name = "myClubRepository")
//	private MyClubRepository myClubRepository;
//
//	@MockBean(name = "memberRepository")
//	private MemberRepository memberRepository;
//
//	@MockBean(name = "clubRepository")
//	private ClubRepository clubRepository;
//
//	@MockBean(name = "memberFindDao")
//	private MemberFindDao memberFindDao;
//
//	@MockBean(name = "clubFindDao")
//	private ClubFindDao clubFindDao;
//
//	@Autowired
//	private MyClubCreateService myClubCreateService;
//
//
//	@Test
//	public void createMyClub_성공() {
//
//		//given
//		Member member = Member.builder()
//				.build();
//
//		Club club = Club.builder()
//				.build();
//
//		given(memberFindDao.findByEmail(any())).willReturn(member);
//		given(clubFindDao.findById(any())).willReturn(club);
//
//		MyClubCreateRequest myClubCreateRequest = MyClubCreateRequest.builder()
//				.email(anyString())
//				.clubId(anyLong())
//				.build();
//
//		//when
//		myClubCreateService.createMyClub(myClubCreateRequest);
//
//		//then
//		assertThat(myClubRepository.findAll(), is(notNullValue()));
//	}
//
//
//}
