package com.youngman.mop.domain.club.service;

import com.youngman.mop.domain.club.dto.ClubInfoResponse;
import com.youngman.mop.domain.member.repository.MemberFindDao;
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
	private final MemberFindDao memberFindDao;
	private final ModelMapper modelMapper;
	private final RedisTemplate<String, ClubInfoResponse> redisTemplate;


	public ClubPagingResponse fetchPagingClubsByMember(String email, PageRequest pageable) {
		Page<MyClubResponse> pagingMyClubResponseDto = clubRepository.fetchPagingClubsByMember(email,
				memberFindDao.findAddressByEmail(email), pageable);

		return ClubPagingResponse.of(pagingMyClubResponseDto);
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
		TypeMap<Club, ClubInfoResponse.ClubInfo> typeMap = modelMapper.getTypeMap(Club.class, ClubInfoResponse.ClubInfo.class);
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<Club, ClubInfoResponse.ClubInfo>() {
				protected void configure() {
					map().setClubId(source.getId());
				}
			});
		}
	}

	private ClubInfoResponse convertModelToDto(Club club) {
		ClubInfoResponse.ClubInfo clubInfo = modelMapper.map(club, ClubInfoResponse.ClubInfo.class);
		List<ClubInfoResponse.MemberInfo> memberInfos = club.getMyClubs().stream()
				.map(i -> modelMapper.map(i.getMember(), ClubInfoResponse.MemberInfo.class))
				.collect(Collectors.toList());

		return ClubInfoResponse.builder()
				.clubInfo(clubInfo)
				.memberInfos(memberInfos)
				.build();
	}

}
