//package com.youngman.mop.service;
//
//import com.youngman.mop.domain.myclub.dto.MyClubResponse;
//import com.youngman.mop.domain.myclub.dao.MyClubRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
///**
// * Created by YoungMan on 2019-05-24.
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MyClubRepositoryImplTest {
//
//	@Autowired
//	private MyClubRepository myClubRepository;
//
//	@Test
//	public void fetchMyClubsByMemberEmail() throws Exception {
//		List<MyClubResponse> myClubs =  myClubRepository.fetchMyClubsByMemberEmail("test");
//		System.out.println(myClubs.size());
//	}
//}
