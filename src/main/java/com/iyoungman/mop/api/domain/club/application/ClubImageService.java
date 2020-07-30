package com.iyoungman.mop.api.domain.club.application;

import com.iyoungman.mop.api.domain.club.api.response.ClubImageResponse;
import com.iyoungman.mop.api.domain.club.application.query.impl.ClubRedisCacheService;
import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.club.domain.ClubRepository;
import com.iyoungman.mop.api.domain.club.exception.ClubNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import com.youngman.mop.common.aws.S3Uploader;

/**
 * Created by YoungMan on 2019-07-14.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubImageService {

    private final ClubRepository clubRepository;
//    private final S3Uploader s3Uploader;
    private final ClubRedisCacheService clubCache;


    public ClubImageResponse uploadClubImage(Long clubId, MultipartFile imageFile) {
//        clubCache.delete(clubId);
        Club club = clubRepository.findById(clubId).orElseThrow(ClubNotFoundException::new);

//        String imageUri = s3Uploader.uploadFile(imageFile, generateFileName(clubId));
//        club.updateClubImagePath(imageUri);
//        clubRepository.save(club);
//        return imageUri;
        return null;
    }

    private String generateFileName(Long clubId) {
        return clubId + "_" + "image.png";
    }
}
