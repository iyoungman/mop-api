package com.youngman.mop.service;

import com.youngman.mop.domain.dto.MemberCreateRequestDto;
import com.youngman.mop.repository.MemberRepository;
import com.youngman.mop.service.member.MemberCreateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by YoungMan on 2019-05-23.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberCreateService memberCreateService;


	@Test
	public void signUp() throws Exception {

		//given
		MemberCreateRequestDto memberCreateRequestDto = MemberCreateRequestDto.builder()
				.email("Test@email.com")
				.name("이영준")
				.pw("PW")
				.address("ADDRESS")
				.mobile("01053221661")
				.build();

		//when
		memberCreateService.createMember(memberCreateRequestDto);

		//then
		assertThat(memberRepository.findByEmail(memberCreateRequestDto.getEmail()).get(),
				is(notNullValue()));
		assertThat(memberRepository.findByEmail(memberCreateRequestDto.getEmail()).get().getEmail(),
				is(memberCreateRequestDto.getEmail()));

	}
}
