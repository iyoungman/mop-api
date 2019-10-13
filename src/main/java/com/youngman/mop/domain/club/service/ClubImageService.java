package com.youngman.mop.domain.club.service;

import com.youngman.mop.domain.club.dao.ClubFindDao;
import com.youngman.mop.domain.club.dao.ClubRepository;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.domain.ClubCacheKey;
import com.youngman.mop.infra.aws.S3Uploader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by YoungMan on 2019-07-14.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubImageService {

    private final ClubRepository clubRepository;
    private final ClubFindDao clubFindDao;
    private final S3Uploader s3Uploader;
    private final ClubCache clubCache;

    @CachePut(value = ClubCacheKey.CLUB_INFO, key = "#clubId")
    public String uploadClubImage(Long clubId, MultipartFile imageFile) {
        Club club = clubFindDao.findById(clubId);
        String imageUri = s3Uploader.uploadFile(imageFile, generateFileName(clubId));
        club.updateClubImagePath(imageUri);
        clubRepository.save(club);
        return imageUri;
    }

    private String generateFileName(Long clubId) {
        return clubId + "_" + "image.png";
    }
}
