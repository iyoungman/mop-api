package com.youngman.mop.service.club;

import com.youngman.mop.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubDeleteService {

	private final ClubRepository clubRepository;
	private final RedisTemplate redisTemplate;


	public void deleteClub(Long clubId) {
		String key = "club_" + clubId;
		boolean hasKey = redisTemplate.hasKey(key);
		if(hasKey) {
			redisTemplate.delete(key);
		}

		clubRepository.deleteById(clubId);
	}
}
