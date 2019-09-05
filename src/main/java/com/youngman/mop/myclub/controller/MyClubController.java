package com.youngman.mop.myclub.controller;

import com.youngman.mop.myclub.service.MyClubCreateService;
import com.youngman.mop.myclub.service.MyClubDeleteService;
import com.youngman.mop.myclub.service.MyClubFetchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mop/myclub")
public class MyClubController {

    private final MyClubCreateService myClubCreateService;
    private final MyClubFetchService myClubFetchService;
    private final MyClubDeleteService myClubDeleteService;


    @PostMapping
    public void createMyClub(@RequestBody MyClubCreateRequest myClubCreateRequest) {
        myClubCreateService.createMyClub(myClubCreateRequest);
    }

    @GetMapping
    public List<MyClubResponse> fetchMyClubsByMemberEmail(@RequestParam("email") String email) {
        return myClubFetchService.fetchMyClubsByMemberEmail(email);
    }

    @DeleteMapping
    public void deleteMyClub(@RequestParam("email") String email, @RequestParam("clubId") Long clubId) {
        myClubDeleteService.deleteMyClub(email, clubId);
    }

}
