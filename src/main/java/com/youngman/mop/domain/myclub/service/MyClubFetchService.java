package com.youngman.mop.domain.myclub.service;

import com.youngman.mop.domain.myclub.controller.dto.MyClubResponse;
import com.youngman.mop.domain.myclub.domain.MyClubRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
