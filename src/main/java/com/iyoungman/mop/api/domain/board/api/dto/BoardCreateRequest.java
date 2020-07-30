package com.iyoungman.mop.api.domain.board.api.dto;

import com.iyoungman.mop.api.common.model.Writer;
import com.iyoungman.mop.api.domain.board.domain.Board;
import com.iyoungman.mop.api.domain.board.domain.BoardItem;
import com.iyoungman.mop.api.domain.board.domain.BoardType;
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

    private BoardType boardType;

    private Long clubId;

    private Long memberId;

    private String memberName;

    @Builder
    public BoardCreateRequest(String title, String content, BoardType boardType,
            Long clubId, Long memberId, String memberName) {
        this.title = title;
        this.content = content;
        this.boardType = boardType;
        this.clubId = clubId;
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public Board toEntity() {
        return Board.builder()
                .clubId(clubId)
                .writer(toWriter())
                .boardItem(toBoardItem())
                .build();
    }

    private BoardItem toBoardItem() {
        return BoardItem.builder()
                .title(title)
                .content(content)
                .boardType(boardType)
                .build();
    }

    private Writer toWriter() {
        return new Writer(memberId, memberName);
    }
}
