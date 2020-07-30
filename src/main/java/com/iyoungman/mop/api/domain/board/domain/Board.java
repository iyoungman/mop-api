package com.iyoungman.mop.api.domain.board.domain;

import com.iyoungman.mop.api.common.model.BaseTime;
import com.iyoungman.mop.api.common.model.Writer;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Entity
@Table(name = "board_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(name = "club_id")
    private Long clubId;

    @Embedded
    private BoardItem boardItem;

    @Embedded
    private Writer writer;

//    @JsonIgnore
//    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
//    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Board(Long clubId, BoardItem boardItem, Writer writer) {
        this.clubId = clubId;
        this.boardItem = boardItem;
        this.writer = writer;
    }

    public void check(BoardValidator boardValidator) {
        boardValidator.validate(this);
    }

    public void checkWriter(Long memberIdByToken) {
        writer.checkWriter(memberIdByToken);
    }

    public void updateBoardItem(String title, String content) {
        boardItem.updateTitleAndContent(title, content);
    }

    public BoardType getBoardType() {
        return boardItem.getBoardType();
    }

    public Long getWriterId() {
        return writer.getWriterId();
    }

    public String getWriterName() {
        return writer.getWriterName();
    }
}
