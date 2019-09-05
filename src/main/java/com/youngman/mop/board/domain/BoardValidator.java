package com.youngman.mop.board.domain;

import com.youngman.mop.club.domain.ClubRepository;
import com.youngman.mop.member.domain.MemberRepository;
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
        validateBoardItem(board.getBoardItem());
    }

    private void validateBoardItem(BoardItem boardItem) {
        if(boardItem.isValid()) {
            throw new IllegalArgumentException("게시판 내용이 잘못되었습니다.");
        }
    }

}
