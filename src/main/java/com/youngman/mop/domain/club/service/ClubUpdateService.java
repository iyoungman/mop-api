package com.youngman.mop.domain.club.service;

import com.youngman.mop.global.error.UserDefineException;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.dto.ClubCreateRequest;
import com.youngman.mop.domain.club.repository.ClubRepository;
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


	public void updateClub(ClubCreateRequest clubCreateRequest) {
		String key = "club_" + clubCreateRequest.getClubId();
		boolean hasKey = redisTemplate.hasKey(key);
		if(hasKey) {
			redisTemplate.delete(key);
		}

		Club club = findById(clubCreateRequest.getClubId());
		club.updateClub(clubCreateRequest);
		clubRepository.save(club);
	}

	private Club findById(Long clubId) {
		return clubRepository.findById(clubId).orElseThrow(
				() -> new UserDefineException("존재하지 않는 동호회입니다.")
		);
	}
}
