package com.youngman.mop.domain.board.dao;

import com.youngman.mop.domain.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-06-18.
 */

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {

}
