package com.youngman.mop.original.myclub.service;

import com.youngman.mop.original.myclub.domain.MyClubRepository;
import com.youngman.mop.original.myclub.controller.MyClubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class MyClubFetchService {

    private final MyClubRepository myClubRepository;

    public List<MyClubResponse> fetchMyClubsByMemberEmail(String email) {
        return myClubRepository.fetchMyClubsByMemberEmail(email);
    }
}
