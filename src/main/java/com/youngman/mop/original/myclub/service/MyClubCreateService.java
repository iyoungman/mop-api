package com.youngman.mop.original.myclub.service;

import com.youngman.mop.domain.member.infra.repository.MemberFindDao;
import com.youngman.mop.original.myclub.domain.MyClub;
import com.youngman.mop.original.myclub.controller.MyClubCreateRequest;
import com.youngman.mop.original.myclub.domain.MyClubRepository;
import com.youngman.mop.original.myclub.exception.MyClubAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-12.
 */

@Service
@RequiredArgsConstructor
public class MyClubCreateService {

    private final MyClubRepository myClubRepository;
    private final MemberFindDao memberFindDao;
    private final ClubFindDao clubFindDao;


    public void createMyClub(MyClubCreateRequest myClubCreateRequest) {
        if (myClubRepository.isExistMyClubByMemberEmailAndClubId(myClubCreateRequest.getEmail(), myClubCreateRequest.getClubId())) {
            throw new MyClubAlreadyExistException();
        }

        MyClub myClub = MyClub.of(
                memberFindDao.findByEmail(myClubCreateRequest.getEmail()),
                clubFindDao.findById(myClubCreateRequest.getClubId())
        );
        myClubRepository.save(myClub);
    }
}
