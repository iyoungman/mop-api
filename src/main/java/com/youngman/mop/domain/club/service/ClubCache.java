package com.youngman.mop.domain.club.service;

import com.youngman.mop.domain.club.dto.ClubInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * Created by YoungMan on 2019-07-18.
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class ClubCache {

	private final RedisTemplate<String, ClubInfoResponse> redisTemplate;


	private String generateKey(Long clubId) {
		return "club_" + clubId;
	}

	public ClubInfoResponse fromCache(Long clubId) {
		String key = generateKey(clubId);
		ValueOperations<String, ClubInfoResponse> operations = redisTemplate.opsForValue();
		return redisTemplate.hasKey(key) ? operations.get(key) : null;
	}

	public void toCache(Long clubId, ClubInfoResponse clubInfoResponse) {
		String key = generateKey(clubId);
		ValueOperations<String, ClubInfoResponse> operations = redisTemplate.opsForValue();
		operations.set(key, clubInfoResponse);
	}

	public void delete(Long clubId) {
		String key = generateKey(clubId);
		boolean hasKey = redisTemplate.hasKey(key);
		if(hasKey) {
			redisTemplate.delete(key);
		}
	}


}
