package com.youngman.mop.club.service;

import com.youngman.mop.club.controller.ClubInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnection;
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

    ClubInfoResponse fromCache(Long clubId) {
        String key = generateKey(clubId);
        ValueOperations<String, ClubInfoResponse> operations = redisTemplate.opsForValue();
        return redisTemplate.hasKey(key) ? operations.get(key) : null;
    }

    void toCache(Long clubId, ClubInfoResponse clubInfoResponse) {
        String key = generateKey(clubId);
        ValueOperations<String, ClubInfoResponse> operations = redisTemplate.opsForValue();
        operations.set(key, clubInfoResponse);
    }

    void delete(Long clubId) {
        String key = generateKey(clubId);
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
        }
    }

    public boolean isConnected() {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        return !connection.isClosed();
    }

}
