package com.youngman.mop.domain.board.domain;

import com.youngman.mop.domain.common.model.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @OneToOne
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

}
