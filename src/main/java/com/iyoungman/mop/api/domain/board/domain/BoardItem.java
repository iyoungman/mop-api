package com.iyoungman.mop.api.domain.board.domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-08-19.
 */

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardItem {

    private String title;

    @Lob
    private String content;

    @Enumerated(EnumType.STRING)
    private BoardType boardType = BoardType.POST;

    @Builder
    public BoardItem(String title, String content, BoardType boardType) {
        this.title = title;
        this.content = content;
        this.boardType = boardType;
    }

    boolean isValid() {
        return !title.isEmpty() && !content.isEmpty();
    }

    void updateTitleAndContent(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
