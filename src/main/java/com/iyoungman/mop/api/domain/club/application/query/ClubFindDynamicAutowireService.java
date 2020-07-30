package com.iyoungman.mop.api.domain.club.application.query;

import java.util.Map;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * Created by iyoungman on 2020-07-30.
 */

@Service
public class ClubFindDynamicAutowireService {

    private final CacheManager cacheManager;

    /**
     * ClubFindService 의 구현체를 주입한다.
     * https://siyoon210.tistory.com/146
     * https://www.baeldung.com/spring-dynamic-autowire
     */
    private final Map<String, ClubFindService> clubFindServiceMap;

    public ClubFindDynamicAutowireService(RedisCacheManager cacheManager,
            Map<String, ClubFindService> clubFindServiceMap) {
        this.cacheManager = cacheManager;
        this.clubFindServiceMap = clubFindServiceMap;
    }

//    public boolean isRedisServerActive() {
//        return cacheManager.
//    }
}
