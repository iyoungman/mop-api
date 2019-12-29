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

@Entity
@Table(name = "board_item_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_item_id")
    private Long id;

    private String title;

    @Lob
    private String content;

    private String writer;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

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
