package com.youngman.mop.service;

import com.youngman.mop.domain.club.dto.ClubInfoResponse;
import com.youngman.mop.domain.club.repository.ClubRepositoryImpl;
import com.youngman.mop.domain.club.service.ClubFetchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by YoungMan on 2019-05-30.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClubRepositoryImplTest {

	@Autowired
	private ClubRepositoryImpl clubRepository;

	@Autowired
	private ClubFetchService clubFetchService;

	@Autowired
	private ModelMapper modelMapper;

	@Test
	public void ff() throws Exception {
		/*Club list = clubRepository.fetchClubInfoById(1L);
		System.out.println(list);*/

		/*modelMapper.addMappings(new PropertyMap<Club, ClubInfoResponse.ClubInfo>() {
			protected void configure() {
				map().setClubId(source.getId());
			}
		});

		ClubInfoResponse.ClubInfo clubDto = modelMapper.map(list, ClubInfoResponse.ClubInfo.class);

		ClubInfoResponse.MemberInfo memberDto = modelMapper.map(list.getMyClubs().get(0).getMember(), ClubInfoResponse.MemberInfo.class);
		System.out.println(memberDto);


		System.out.println(clubDto);*/

		/*List<Member> members = list.getMyClubs().stream()
				.map(i -> i.getMember())
				.collect(Collectors.toList());

		ClubInfoResponse clubInfoResponse =  ClubInfoResponse.builder()
				.club(list)
				.members(members)
				.build();

		System.out.println("haha");*/

		ClubInfoResponse clubInfoResponse = clubFetchService.fetchClubInfoById(1L);
		System.out.println("haha");
	}
}
