package com.youngman.mop.domain.board.api.dto;

import com.youngman.mop.domain.board.domain.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardPagingResponse {

    private boolean isLast;
    private boolean isEmpty;
    private List<Board> notices = new ArrayList<>();
    private List<Board> posts = new ArrayList<>();

    @Builder
    public BoardPagingResponse(boolean isLast, boolean isEmpty, List<Board> notices, List<Board> posts) {
        this.isLast = isLast;
        this.isEmpty = isEmpty;
        this.notices = notices;
        this.posts = posts;
    }


}
