package com.youngman.mop.domain.board.controller;

import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.board.domain.BoardItem;
import com.youngman.mop.domain.board.domain.BoardType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardCreateRequest {

    private String title;
    private String content;
    private String writer;
    private BoardType boardType;
    private Long clubId;
    private Long userId;


    @Builder
    public BoardCreateRequest(String title, String content, String writer,
                              BoardType boardType, Long clubId, Long userId) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardType = boardType;
        this.clubId = clubId;
        this.userId = userId;
    }

    public Board toEntity() {
        return Board.builder()
                .clubId(clubId)
                .userId(userId)
                .boardItem(toBoardItem())
                .build();
    }

    private BoardItem toBoardItem() {
        return BoardItem.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .boardType(boardType)
                .build();
    }
}
