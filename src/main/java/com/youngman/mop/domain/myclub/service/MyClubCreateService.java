package com.youngman.mop.domain.myclub.service;

import com.youngman.mop.domain.myclub.controller.dto.MyClubCreateRequest;
import com.youngman.mop.domain.myclub.domain.MyClub;
import com.youngman.mop.domain.myclub.domain.MyClubRepository;
import com.youngman.mop.domain.myclub.domain.MyClubValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-12.
 */

@Service
@RequiredArgsConstructor
public class MyClubCreateService {

    private final MyClubRepository myClubRepository;

    private final MyClubValidator myClubValidator;

    public void createMyClub(MyClubCreateRequest myClubCreateRequest) {
        MyClub myClub = myClubCreateRequest.toEntity();
        myClub.validate(myClubValidator);

        myClubRepository.save(myClub);
    }
}
