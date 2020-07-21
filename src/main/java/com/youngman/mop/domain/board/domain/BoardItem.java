package com.youngman.mop.domain.board.domain;

import com.youngman.mop.domain.board.exception.InvalidWriterException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private String writer;

    @Enumerated(EnumType.STRING)
    private BoardType boardType = BoardType.POST;

    @Builder
    public BoardItem(String title, String content,
                     String writer, BoardType boardType) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardType = boardType;
    }

    void checkWriter(String jwtWriter) {
        if (!writer.equals(jwtWriter)) {
            throw new InvalidWriterException();
        }
    }

    boolean isValid() {
        return !title.isEmpty() && !content.isEmpty() && !writer.isEmpty();
    }

    void updateTitleAndContent(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
