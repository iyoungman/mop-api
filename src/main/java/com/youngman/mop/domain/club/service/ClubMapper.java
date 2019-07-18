package com.youngman.mop.domain.club.service;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.dto.ClubInfoResponse;
import com.youngman.mop.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-07-18.
 */

@Component
@RequiredArgsConstructor
public class ClubMapper {

	private final ModelMapper modelMapper;


	public ClubInfoResponse mapFrom(Club club) {
		prepareModelMapper();

		return ClubInfoResponse.builder()
				.clubInfo(toClubInfo(club))
				.memberInfos(toMemberInfos(club))
				.build();
	}

	private void prepareModelMapper() {
		TypeMap<Club, ClubInfoResponse.ClubInfo> typeMap = modelMapper.getTypeMap(Club.class, ClubInfoResponse.ClubInfo.class);

		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<Club, ClubInfoResponse.ClubInfo>() {
				protected void configure() {
					map().setClubId(source.getId());
					map().setCreateDate(source.getCreatedDate());
					map().setImageUri(source.getImagePath());
				}
			});
		}
	}

	private ClubInfoResponse.ClubInfo toClubInfo(Club club) {
		return modelMapper.map(club, ClubInfoResponse.ClubInfo.class);
	}

	private List<ClubInfoResponse.MemberInfo> toMemberInfos(Club club) {
		return club.getMyClubs()
				.stream()
				.map(c -> toMemberInfo(c.getMember()))
				.collect(Collectors.toList());
	}

	private ClubInfoResponse.MemberInfo toMemberInfo(Member member) {
		return modelMapper.map(member, ClubInfoResponse.MemberInfo.class);
	}

}
