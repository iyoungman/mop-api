package com.youngman.mop.domain.myclub.domain;

import com.youngman.mop.domain.club.command.domain.Club;
import com.youngman.mop.domain.club.command.domain.ClubRepository;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.domain.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by iyoungman on 2020-06-16.
 */

@Component
@RequiredArgsConstructor
public class MyClubValidator {

    private final MyClubRepository myClubRepository;

    private final ClubRepository clubRepository;

    private final MemberRepository memberRepository;

    public void validate(MyClub myClub) {
        if (getClub(myClub).isPresent()) {
            throw new IllegalArgumentException("삭제된 동호회 입니다.");
        }

        //TODO Optional isPresent 확인
        if (getMember(myClub).isPresent()) {
            throw new IllegalArgumentException("탈퇴한 멤버입니다.");
        }

        //이미 가입된 동호회인지 확인
        //TODO Email -> PK
        if (myClubRepository.isExistMyClubByMemberEmailAndClubId(String.valueOf(myClub.getMemberId()), myClub.getMemberId())) {
            throw new IllegalArgumentException("이미 가입된 동호회입니다.");
        }
    }

    private Optional<Club> getClub(MyClub myClub) {
        return clubRepository.findById(myClub.getClubId());
    }

    private Optional<Member> getMember(MyClub myClub) {
        return memberRepository.findById(myClub.getMemberId());
    }
}
