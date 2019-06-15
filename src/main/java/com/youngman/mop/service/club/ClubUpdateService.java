package com.youngman.mop.service.club;

import com.youngman.mop.exception.UserDefineException;
import com.youngman.mop.domain.entity.Club;
import com.youngman.mop.domain.dto.ClubCreateRequestDto;
import com.youngman.mop.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubUpdateService {

	private final ClubRepository clubRepository;
	private final RedisTemplate redisTemplate;


	public void updateClub(ClubCreateRequestDto clubCreateRequestDto) {
		String key = "club_" + clubCreateRequestDto.getClubId();
		boolean hasKey = redisTemplate.hasKey(key);
		if(hasKey) {
			redisTemplate.delete(key);
		}

		Club club = findById(clubCreateRequestDto.getClubId());
		club.updateClub(clubCreateRequestDto);
		clubRepository.save(club);
	}

	private Club findById(Long clubId) {
		return clubRepository.findById(clubId).orElseThrow(
				() -> new UserDefineException("존재하지 않는 동호회입니다.")
		);
	}
}
