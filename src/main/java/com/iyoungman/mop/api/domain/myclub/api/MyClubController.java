package com.iyoungman.mop.api.domain.myclub.api;

import com.iyoungman.mop.api.domain.myclub.api.dto.MyClubCreateRequest;
import com.iyoungman.mop.api.domain.myclub.api.dto.MyClubResponse;
import com.iyoungman.mop.api.domain.myclub.application.MyClubCreateService;
import com.iyoungman.mop.api.domain.myclub.application.MyClubDeleteService;
import com.iyoungman.mop.api.domain.myclub.application.MyClubFindService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mop/myclub")
public class MyClubController {

    private final MyClubCreateService myClubCreateService;

    private final MyClubFindService myClubFetchService;

    private final MyClubDeleteService myClubDeleteService;

    @PostMapping
    public void createMyClub(@RequestBody MyClubCreateRequest myClubCreateRequest) {
        myClubCreateService.createMyClub(myClubCreateRequest);
    }

    @GetMapping
    public List<MyClubResponse> fetchMyClubsByMemberEmail(@RequestParam("memberId") Long memberId) {
        return myClubFetchService.findMyClubsByMemberId(memberId);
    }

    @DeleteMapping
    public void deleteMyClub(@RequestParam("memberId") Long memberId, @RequestParam("clubId") Long clubId) {
        myClubDeleteService.deleteMyClub(memberId, clubId);
    }

}
