package com.youngman.mop.domain.club.service;

import com.youngman.mop.domain.club.dto.ClubInfoResponse;
import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import com.youngman.mop.domain.club.dto.ClubPagingResponse;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.repository.ClubRepository;
import com.youngman.mop.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubFetchService {

	private final ClubRepository clubRepository;
	private final MemberRepository memberRepository;
	private final ModelMapper modelMapper;
	private final RedisTemplate redisTemplate;


	public ClubPagingResponse fetchPagingClubsByMember(String email, PageRequest pageable) {
		Page<MyClubResponse> pagingMyClubResponseDto = clubRepository.fetchPagingClubsByMember(email,
				findAddressByEmail(email), pageable);

		return ClubPagingResponse.of(pagingMyClubResponseDto);
	}

	private String findAddressByEmail(String email) {
		return memberRepository.findByEmail(email).get().getAddress();
	}

	public ClubInfoResponse fetchClubInfoById(Long clubId) {
		String key = "club_" + clubId;
		ValueOperations<String, ClubInfoResponse> operations = redisTemplate.opsForValue();
		boolean hasKey = redisTemplate.hasKey(key);

		if (hasKey) {
			log.info("hasKey => {}", hasKey);
			ClubInfoResponse clubInfoResponse = operations.get(key);
			return clubInfoResponse;
		}

		Optional<Club> club = clubRepository.fetchClubInfoById(clubId);
		if (club.isPresent()) {
			prepareModelMapper();
			ClubInfoResponse clubInfoResponse = convertModelToDto(club.get());
			operations.set(key, clubInfoResponse);
			return clubInfoResponse;
		}

		return new ClubInfoResponse();
	}

	private void prepareModelMapper() {
		TypeMap<Club, ClubInfoResponse.ClubDto> typeMap = modelMapper.getTypeMap(Club.class, ClubInfoResponse.ClubDto.class);
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<Club, ClubInfoResponse.ClubDto>() {
				protected void configure() {
					map().setClubId(source.getId());
				}
			});
		}
	}

	private ClubInfoResponse convertModelToDto(Club club) {
		ClubInfoResponse.ClubDto clubDto = modelMapper.map(club, ClubInfoResponse.ClubDto.class);
		List<ClubInfoResponse.MemberDto> memberDtos = club.getMyClubs().stream()
				.map(i -> modelMapper.map(i.getMember(), ClubInfoResponse.MemberDto.class))
				.collect(Collectors.toList());

		return ClubInfoResponse.builder()
				.clubDto(clubDto)
				.memberDtos(memberDtos)
				.build();
	}

}
