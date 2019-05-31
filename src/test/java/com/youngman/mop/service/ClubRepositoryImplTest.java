package com.youngman.mop.service;

import com.youngman.mop.model.domain.Club;
import com.youngman.mop.model.domain.Member;
import com.youngman.mop.model.domain.MyClub;
import com.youngman.mop.model.dto.ClubInfoResponseDto;
import com.youngman.mop.repository.ClubRepository;
import com.youngman.mop.repository.MyClubRepository;
import com.youngman.mop.repository.impl.ClubRepositoryImpl;
import com.youngman.mop.service.club.ClubFetchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

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

		/*modelMapper.addMappings(new PropertyMap<Club, ClubInfoResponseDto.ClubDto>() {
			protected void configure() {
				map().setClubId(source.getId());
			}
		});

		ClubInfoResponseDto.ClubDto clubDto = modelMapper.map(list, ClubInfoResponseDto.ClubDto.class);

		ClubInfoResponseDto.MemberDto memberDto = modelMapper.map(list.getMyClubs().get(0).getMember(), ClubInfoResponseDto.MemberDto.class);
		System.out.println(memberDto);


		System.out.println(clubDto);*/

		/*List<Member> members = list.getMyClubs().stream()
				.map(i -> i.getMember())
				.collect(Collectors.toList());

		ClubInfoResponseDto clubInfoResponseDto =  ClubInfoResponseDto.builder()
				.club(list)
				.members(members)
				.build();

		System.out.println("haha");*/

		ClubInfoResponseDto clubInfoResponseDto = clubFetchService.fetchClubInfoById(1L);
		System.out.println("haha");
	}
}
