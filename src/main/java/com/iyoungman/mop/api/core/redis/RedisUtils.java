package com.iyoungman.mop.api.core.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * Created by iyoungman on 2020-07-30.
 */

@Component
@RequiredArgsConstructor
public class RedisUtils {

    private final RedisTemplate<String, Object> redisTemplate;

    public String generateKey(String domain, Long id) {
        return domain + id;
    }

    public Object fromCache(String key) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        return redisTemplate.hasKey(key) ? operations.get(key) : null;
    }

    public void toCache(String key, Object object) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key, object);
    }

    public void delete(String key) {
        if (redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
        }
    }

    public boolean isConnected() {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();

        boolean result = !connection.isClosed();
        connection.close();

        return result;
    }

}
