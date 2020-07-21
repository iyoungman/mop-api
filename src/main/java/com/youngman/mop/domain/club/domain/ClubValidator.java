package com.youngman.mop.domain.club.domain;

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
public class ClubValidator {

    private final ClubRepository clubRepository;

    private final MemberRepository memberRepository;

    public void validate(Club club) {
        if (getClub(club).isPresent()) {
            throw new IllegalArgumentException("중복되는 동호회 이름입니다.");
        }

        if (!getMember(club).isPresent()) {
            throw new IllegalArgumentException("탈퇴한 회원입니다.");
        }
    }

    private Optional<Club> getClub(Club club) {
        return clubRepository.findByName(club.getName());
    }

    private Optional<Member> getMember(Club club) {
        return memberRepository.findById(club.getClubChair().getChairManId());
    }
}
