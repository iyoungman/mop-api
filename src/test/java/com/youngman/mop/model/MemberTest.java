package com.youngman.mop.model;

import com.youngman.mop.model.dto.MemberDto;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat
import static org.mockito.Mockito.mock;

/**
 * Created by YoungMan on 2019-05-10.
 */

public class MemberTest {

	private Member member;

	@Before
	public void setUp() {
		member = new Member();
	}

	@Test
	public void of() throws Exception {

		//given
		MemberDto.SignUpRequest signUpRequest = mock(MemberDto.SignUpRequest.class);

		//when
		member = member.of(signUpRequest);

		//then
		assertThat(member, is(notNullValue()));
	}

	@Test
	public void updateMember() throws Exception {

		//given
		MemberDto.SignUpRequest signUpRequest = mock(MemberDto.SignUpRequest.class);

		//when
		member.updateMember(signUpRequest);

		//then
		assertThat();
	}

}
