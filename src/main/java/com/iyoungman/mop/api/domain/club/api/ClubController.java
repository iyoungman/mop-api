package com.iyoungman.mop.api.domain.club.api;

import com.iyoungman.mop.api.domain.club.api.request.ClubCreateRequest;
import com.iyoungman.mop.api.domain.club.api.response.ClubImageResponse;
import com.iyoungman.mop.api.domain.club.api.response.ClubInfoResponse;
import com.iyoungman.mop.api.domain.club.api.response.ClubPagingResponse;
import com.iyoungman.mop.api.domain.club.application.ClubCreateService;
import com.iyoungman.mop.api.domain.club.application.ClubDeleteService;
import com.iyoungman.mop.api.domain.club.application.ClubImageService;
import com.iyoungman.mop.api.domain.club.application.query.ClubFindService;
import com.iyoungman.mop.api.domain.club.domain.ClubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mop/club")
public class ClubController {

    private final ClubCreateService clubCreateService;

    private final ClubDeleteService clubDeleteService;

    private final ClubImageService clubImageService;

    private final ClubFindService clubFindService;

    private final ClubRepository clubRepository;

    @PostMapping
    public void createClub(@RequestBody ClubCreateRequest clubCreateRequest) {
        clubCreateService.createClub(clubCreateRequest);
    }

    @GetMapping("/chair")
    public boolean isClubChair(@RequestParam("clubId") Long clubId,
            @RequestParam("memberId") Long memberId) {

        //TODO
//        return clubRepository.isClubChair(clubId, memberId);
        return false;
    }

    @GetMapping("/member")
    public ClubPagingResponse selectPagingClubsByMemberAddress(@RequestParam("memberId") Long memberId,
            @RequestParam("pageNo") int pageNo) {

        PageRequest pageRequest = PageRequest.of(pageNo - 1, 24);
        return clubFindService.selectPagingClubsByMember(memberId, pageRequest);
    }

    @GetMapping("/info")
    public ClubInfoResponse selectClubInfoById(@RequestParam("clubId") Long clubId) {
        return clubFindService.selectClubInfoById(clubId);
    }

    @PutMapping
    public void updateClub(@RequestBody ClubCreateRequest clubCreateRequest) {
//        clubUpdateService.updateClub(clubCreateRequest);
    }

    @DeleteMapping
    public void deleteClub(@RequestParam("clubId") Long clubId, @RequestParam("memberId") Long memberId) {
        clubDeleteService.deleteClub(clubId, memberId);
    }

    @PostMapping("/image")
    public ClubImageResponse uploadClubImage(@RequestPart("clubId") Long clubId,
            @RequestPart("image") MultipartFile imageFile) {

        return clubImageService.uploadClubImage(clubId, imageFile);
    }
}
