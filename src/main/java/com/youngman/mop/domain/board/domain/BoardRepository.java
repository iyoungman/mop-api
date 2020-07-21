package com.youngman.mop.domain.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 * Created by YoungMan on 2019-06-18.
 */

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {

    @Query("SELECT b.boardItem.writer FROM Board b where b.id = :id")
    String findWriterById(Long id);
}
