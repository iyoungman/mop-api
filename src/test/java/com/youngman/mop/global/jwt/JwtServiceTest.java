//package com.youngman.mop.global.jwt;
//
//import lombok.extern.slf4j.Slf4j;
//import org.hamcrest.core.IsNot;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.hamcrest.Matchers.not;
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//
///**
// * Created by YoungMan on 2019-06-15.
// */
//
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class JwtServiceTest {
//
//	@Autowired
//	private JwtService jwtService;
//
//	private final String email = "testEmail";
//	private final String name = "testName";
//	private String jwt;
//
//
//	@Before
//	public void createJwt() {
//		jwt = jwtService.createJwt(email, name);
//	}
//
//	@Test
//	public void isUsable() {
//
//		//when
//		boolean isUsable = jwtService.isUsable(jwt);
//
//		//then
//		assertThat(isUsable, is(true));
//	}
//
//	@Test
//	public void findEmailAndNameByJwt_성공() {
//
//		//when
//		String findEmail = jwtService.findEmailByJwt(jwt);
//		String findName = jwtService.findNameByJwt(jwt);
//
//		//then
//		assertThat(email, is(findEmail));
//		assertThat(name, is(findName));
//	}
//
//	@Test
//	public void findEmailAndNameByJwt_실패() {
//
//		//given
//		String invalidEmail = "invalidEmail";
//		String invalidName = "invalidName";
//
//		//when
//		String findEmail = jwtService.findEmailByJwt(jwt);
//		String findName = jwtService.findNameByJwt(jwt);
//
//		//then
//		assertThat(invalidEmail, not(findEmail));
//		assertThat(invalidName, not(findName));
//	}
//}
