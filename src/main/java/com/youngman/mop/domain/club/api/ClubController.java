package com.youngman.mop.domain.club.api;

import com.youngman.mop.domain.club.api.dto.ClubCreateRequest;
import com.youngman.mop.domain.club.api.dto.ClubInfoResponse;
import com.youngman.mop.domain.club.api.dto.ClubPagingResponse;
import com.youngman.mop.domain.club.query.application.ClubFetchService;
import com.youngman.mop.domain.club.query.ClubImageService;
import com.youngman.mop.domain.club.application.ClubCreateService;
import com.youngman.mop.domain.club.application.ClubDeleteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mop/club")
public class ClubController {

    private final ClubCreateService clubCreateService;
//    private final ClubUpdateService clubUpdateService;
    private final ClubDeleteService clubDeleteService;
    private final ClubImageService clubImageService;
    private final ClubFetchService clubFetchService;


    @PostMapping
    public void createClub(@RequestBody ClubCreateRequest clubCreateRequest) {
        clubCreateService.createClub(clubCreateRequest);
    }

    @GetMapping("/chair")
    public boolean isClubChair(@RequestParam("clubId") Long clubId,
                               @RequestParam("email") String email) {
        return clubFindDao.isClubChair(clubId, email);
    }

    @GetMapping("/member")
    public ClubPagingResponse selectPagingClubsByMember(@RequestParam("email") String email,
                                                        @RequestParam("pageNo") int pageNo) {
        return clubFetchService.selectPagingClubsByMember(email, PageRequest.of(pageNo - 1, 24));
    }

    @GetMapping("/info")
    public ClubInfoResponse selectClubInfoById(@RequestParam("clubId") Long clubId) {
        return clubFetchService.selectClubInfoById(clubId);
    }

    @PutMapping
    public void updateClub(@RequestBody ClubCreateRequest clubCreateRequest) {
        clubUpdateService.updateClub(clubCreateRequest);
    }

    @DeleteMapping
    public void deleteClub(@RequestParam("clubId") Long clubId) {
        clubDeleteService.deleteClub(clubId);
    }

    @PostMapping("/image")
    public Map<String, String> uploadClubImage(@RequestPart("clubId") Long clubId,
                                               @RequestPart("image") MultipartFile imageFile) {
        String imageUri = clubImageService.uploadClubImage(clubId, imageFile);
        Map<String, String> response = new HashMap<>();
        response.put("imageUri", imageUri);
        return response;
    }
}
