package com.youngman.mop.domain.board.domain;

import com.youngman.mop.domain.club.command.domain.Club;
import com.youngman.mop.domain.club.command.domain.ClubRepository;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.domain.MemberRepository;
import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by YoungMan on 2019-08-19.
 */

@Component
@RequiredArgsConstructor
public class BoardValidator {

    private final ClubRepository clubRepository;

    private final MemberRepository memberRepository;

    public void validate(Board board) {
        if (!getClub(board).isPresent()) {
            throw new IllegalArgumentException("삭제된 동호회 입니다.");
        }

        if (!getMember(board).isPresent()) {
            throw new IllegalArgumentException("탈퇴한 멤버입니다.");
        }

        validateBoardItem(board.getBoardItem());
    }

    private void validateBoardItem(BoardItem boardItem) {
        if (boardItem.isValid()) {
            throw new IllegalArgumentException("게시판 내용이 잘못되었습니다.");
        }
    }

    private Optional<Club> getClub(Board board) {
        return clubRepository.findById(board.getClubId());
    }

    private Optional<Member> getMember(Board board) {
        return memberRepository.findById(board.getUserId());
    }

}
