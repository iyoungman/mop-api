//package com.youngman.mop.domain.member.service;
//
//import com.youngman.mop.domain.member.dao.MemberFindDao;
//import com.youngman.mop.domain.member.dao.MemberRepository;
//import com.youngman.mop.domain.member.domain.Member;
//import com.youngman.mop.domain.member.dto.MemberCreateRequest;
//import com.youngman.mop.domain.member.exception.EmailDuplicationException;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.TestName;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.transaction.Transactional;
//
//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertTrue;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//
///**
// * Created by YoungMan on 2019-05-23.
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class MemberCreateServiceTest {
//
//	@Autowired
//	private MemberFindDao memberFindDao;
//
//	@Autowired
//	private MemberCreateService memberCreateService;
//
//	@Rule
//	public TestName testName = new TestName();
//
//
//	@Before
//	public void setUp() {
//		assertThat(testName.getMethodName(), is("singUp_실패_이메일중복"));
//
//		MemberCreateRequest memberCreateRequest = MemberCreateRequest.builder()
//				.email("Test")
//				.name("이영준")
//				.pw("PW")
//				.address("ADDRESS")
//				.mobile("01053221661")
//				.build();
//
//		memberCreateService.createMember(memberCreateRequest);
//	}
//
//
//	@Test
//	public void signUp_성공() {
//
//		//given
//		MemberCreateRequest memberCreateRequest = MemberCreateRequest.builder()
//				.email("Test")
//				.name("이영준")
//				.pw("PW")
//				.address("ADDRESS")
//				.mobile("01053221661")
//				.build();
//
//		//when
//		memberCreateService.createMember(memberCreateRequest);
//
//		//then
//		Member findMember = memberFindDao.findByEmail(memberCreateRequest.getEmail());
//
//		assertThat(findMember, is(notNullValue()));
//		assertThat(findMember.getEmail(), is(memberCreateRequest.getEmail()));
//		assertThat(findMember.getName(), is(memberCreateRequest.getName()));
//	}
//
//
//	@Test(expected = EmailDuplicationException.class)
//	public void singUp_실패_이메일중복() {
//
//		//given
//		MemberCreateRequest memberCreateRequest = MemberCreateRequest.builder()
//				.email("Test")
//				.name("이영준")
//				.pw("PW")
//				.address("ADDRESS")
//				.mobile("01053221661")
//				.build();
//
//		//when
//		memberCreateService.createMember(memberCreateRequest);
//	}
//}
