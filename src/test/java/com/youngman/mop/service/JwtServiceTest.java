package com.youngman.mop.service;

import com.youngman.mop.domain.member.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by YoungMan on 2019-06-15.
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtServiceTest {

	@Autowired
	private JwtService jwtService;

	private final String email = "test";
	private String jwt;


//	@Before
//	public void createJwt() throws Exception {
//		jwt = jwtService.createJwt(email);
//		log.info("Jwt => {}", jwt);
//	}

	@Test
	public void isUsable() throws Exception {

		//when
		boolean isUsable = jwtService.isUsable(jwt);

		//then
		assertThat(isUsable, is(true));
	}

	@Test
	public void findEmailByJwt() throws Exception {

		String jwt = "eyJ0eXAiOiJKV1QiLCJpc3N1ZURhdGUiOjE1NjA2MDExMzE0MTgsImFsZyI6IkhTMjU2In0.eyJFTUFJTCI6InRlc3QiLCJleHAiOjE1NjA2MDQ3MzF9.zIC3e4DyNDBAvNgwHFOOl6rjOoC99ibXhxUoRUUuXDc";

		//when
		String findEmail = jwtService.findEmailByJwt(jwt);

		//then
		assertThat(email, is(findEmail));
	}
}
