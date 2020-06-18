//package com.youngman.mop.dw;
//
//import com.youngman.mop.domain.club.command.original.Club;
//import com.youngman.mop.domain.schedule.api.dto.ScheduleCreateRequest;
//import com.youngman.mop.domain.club.command.original.ClubRepository;
//import com.youngman.mop.domain.schedule.domain.ScheduleRepository;
//import com.youngman.mop.original.schedule.dw.ScheduleCreateService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.transaction.Transactional;
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import static org.hamcrest.core.Is.is;
//import static org.hamcrest.core.IsNull.notNullValue;
//import static org.junit.Assert.assertThat;
//import static org.mockito.BDDMockito.given;
//
///**
// * Created by YoungMan on 2019-05-24.
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class ScheduleServiceTest {
//
//	@Autowired
//	private ScheduleRepository scheduleRepository;
//
//	@Autowired
//	private ScheduleCreateService scheduleCreateService;
//
//	@MockBean(name = "clubRepository")
//	private ClubRepository clubRepository;
//
//	@Test
//	public void createSchedule() throws Exception {
//
//		//given
//		Club club = Club.builder()
//				.build();
//
//		given(clubRepository.findById(1L))
//				.willReturn(Optional.of(club));
//
//		ScheduleCreateRequest scheduleCreateRequest = ScheduleCreateRequest.builder()
//				.name("축구모임1")
//				.content("22명 모집합니다")
//				.region("서울")
//				.writer("이영준")
//				.meetingTime(LocalDateTime.now().plusDays(1))
//				.clubId(1L)
//				.build();
//
//		//when
//		scheduleCreateService.createSchedule(scheduleCreateRequest);
//
//		//then
//		assertThat(scheduleRepository.findAll().get(0).getName(), is("축구모임1"));
//	}
//}
