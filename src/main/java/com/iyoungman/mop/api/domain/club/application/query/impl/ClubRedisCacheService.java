package com.iyoungman.mop.api.domain.club.application.query.impl;

import com.iyoungman.mop.api.domain.club.api.response.ClubInfoResponse;
import com.iyoungman.mop.api.domain.club.api.response.ClubPagingResponse;
import com.iyoungman.mop.api.domain.club.application.query.ClubCacheKey;
import com.iyoungman.mop.api.domain.club.application.query.ClubFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2019-07-18.
 */

@Primary
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClubRedisCacheService implements ClubFindService {

    private final ClubMySqlService clubMySqlService;

    @Override
    public ClubPagingResponse selectPagingClubsByMember(Long memberId, PageRequest pageable) {
        return clubMySqlService.selectPagingClubsByMember(memberId, pageable);
    }

    @Override
    @Cacheable(value = ClubCacheKey.CLUB_INFO, key = "#clubId", unless = "#result == null")
    public ClubInfoResponse selectClubInfoById(Long clubId) {
        return clubMySqlService.selectClubInfoById(clubId);
    }

}
