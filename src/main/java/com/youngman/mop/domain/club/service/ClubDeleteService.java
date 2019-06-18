package com.youngman.mop.domain.club.service;

import com.youngman.mop.domain.club.dto.ClubInfoResponse;
import com.youngman.mop.domain.club.dao.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubDeleteService {

	private final ClubRepository clubRepository;
	private final RedisTemplate<String, ClubInfoResponse> redisTemplate;


	public void deleteClub(Long clubId) {
		String key = "club_" + clubId;
		boolean hasKey = redisTemplate.hasKey(key);
		if(hasKey) {
			redisTemplate.delete(key);
		}

		clubRepository.deleteById(clubId);
	}
}
