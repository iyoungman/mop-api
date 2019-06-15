package com.youngman.mop.service.club;

import com.youngman.mop.domain.dto.ClubInfoResponseDto;
import com.youngman.mop.domain.dto.MyClubResponseDto;
import com.youngman.mop.domain.dto.PagingClubResponseDto;
import com.youngman.mop.domain.entity.Club;
import com.youngman.mop.repository.ClubRepository;
import com.youngman.mop.repository.MemberRepository;
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


	public PagingClubResponseDto fetchPagingClubsByMember(String email, PageRequest pageable) {
		Page<MyClubResponseDto> pagingMyClubResponseDto = clubRepository.fetchPagingClubsByMember(email,
				findAddressByEmail(email), pageable);

		return PagingClubResponseDto.of(pagingMyClubResponseDto);
	}

	private String findAddressByEmail(String email) {
		return memberRepository.findByEmail(email).get().getAddress();
	}

	public ClubInfoResponseDto fetchClubInfoById(Long clubId) {
		String key = "club_" + clubId;
		ValueOperations<String, ClubInfoResponseDto> operations = redisTemplate.opsForValue();
		boolean hasKey = redisTemplate.hasKey(key);

		if (hasKey) {
			log.info("hasKey => {}", hasKey);
			ClubInfoResponseDto clubInfoResponseDto = operations.get(key);
			return clubInfoResponseDto;
		}

		Optional<Club> club = clubRepository.fetchClubInfoById(clubId);
		if (club.isPresent()) {
			prepareModelMapper();
			ClubInfoResponseDto clubInfoResponseDto = convertModelToDto(club.get());
			operations.set(key, clubInfoResponseDto);
			return clubInfoResponseDto;
		}

		return new ClubInfoResponseDto();
	}

	private void prepareModelMapper() {
		TypeMap<Club, ClubInfoResponseDto.ClubDto> typeMap = modelMapper.getTypeMap(Club.class, ClubInfoResponseDto.ClubDto.class);
		if (typeMap == null) {
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
