package com.youngman.mop.domain.board.domain;

import com.youngman.mop.common.model.BaseTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

    @Column(name = "user_id")
    private Long userId;

    @Embedded
    private BoardItem boardItem;

//    @JsonIgnore
//    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
//    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Board(Long clubId, Long userId, BoardItem boardItem) {
        this.clubId = clubId;
        this.userId = userId;
        this.boardItem = boardItem;
    }

    public void check(BoardValidator boardValidator) {
        boardValidator.validate(this);
    }

    public void checkWriter(String jwtWriter) {
        boardItem.checkWriter(jwtWriter);
    }

    public void updateBoardItem(String title, String content) {
        boardItem.updateTitleAndContent(title, content);
    }

    public BoardType getBoardType() {
        return boardItem.getBoardType();
    }
}
