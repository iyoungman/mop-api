package com.iyoungman.mop.api.domain.myclub.domain;

import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.club.domain.ClubRepository;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.iyoungman.mop.api.domain.member.domain.MemberRepository;
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
        if (!getClub(myClub).isPresent()) {
            throw new IllegalArgumentException("삭제된 동호회 입니다.");
        }

        if (!getMember(myClub).isPresent()) {
            throw new IllegalArgumentException("탈퇴한 멤버입니다.");
        }

        if (myClubRepository.isExistMyClubByMemberIdAndClubId(myClub.getMemberId(), myClub.getClubId())) {
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
