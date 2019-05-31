package com.youngman.mop.service.club;

import com.youngman.mop.model.domain.Club;
import com.youngman.mop.model.domain.Member;
import com.youngman.mop.model.dto.ClubInfoResponseDto;
import com.youngman.mop.model.dto.MyClubResponseDto;
import com.youngman.mop.model.dto.PagingClubResponseDto;
import com.youngman.mop.repository.ClubRepository;
import com.youngman.mop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubFetchService {

	private final ClubRepository clubRepository;
	private final MemberRepository memberRepository;
	private final ModelMapper modelMapper;


	public PagingClubResponseDto fetchPagingClubsByMember(String email, PageRequest pageable) {
		Page<MyClubResponseDto> pagingMyClubResponseDto = clubRepository.fetchPagingClubsByMember(email,
				findAddressByEmail(email), pageable);

		return PagingClubResponseDto.of(pagingMyClubResponseDto);
	}

	private String findAddressByEmail(String email) {
		return memberRepository.findByEmail(email).get().getAddress();
	}

	public ClubInfoResponseDto fetchClubInfoById(Long clubId) {
		Club club = clubRepository.fetchClubInfoById(clubId);
		settingModelMapper();
		return convertModelToDto(club);
	}

	private void settingModelMapper() {

		TypeMap<Club, ClubInfoResponseDto.ClubDto> typeMap = modelMapper.getTypeMap(Club.class, ClubInfoResponseDto.ClubDto.class);
		if(typeMap == null) {
			modelMapper.addMappings(new PropertyMap<Club, ClubInfoResponseDto.ClubDto>() {
				protected void configure() {
					map().setClubId(source.getId());
				}
			});
		}
	}

	private ClubInfoResponseDto convertModelToDto(Club club) {

		ClubInfoResponseDto.ClubDto clubDto = modelMapper.map(club, ClubInfoResponseDto.ClubDto.class);
		List<ClubInfoResponseDto.MemberDto> memberDtos = club.getMyClubs().stream()
				.map(i -> modelMapper.map(i.getMember(), ClubInfoResponseDto.MemberDto.class))
				.collect(Collectors.toList());

		return ClubInfoResponseDto.builder()
				.clubDto(clubDto)
				.memberDtos(memberDtos)
				.build();
	}
}
