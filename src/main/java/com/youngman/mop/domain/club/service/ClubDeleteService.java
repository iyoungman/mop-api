package com.youngman.mop.domain.club.service;

import com.youngman.mop.domain.club.dao.ClubRepository;
import com.youngman.mop.domain.club.domain.ClubCacheKey;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class ClubDeleteService {

    private final ClubRepository clubRepository;
    private final ClubCache clubCache;

    @CacheEvict(value = ClubCacheKey.CLUB_INFO, key = "#clubId")
    public void deleteClub(Long clubId) {
        clubRepository.deleteById(clubId);
    }
}
