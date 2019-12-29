package com.youngman.mop.domain.board.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created by YoungMan on 2019-06-20.
 */

public interface BoardRepositoryCustom {

	Page<Board> fetchPagingBoardsByClub(Long clubId, PageRequest pageable);
}
