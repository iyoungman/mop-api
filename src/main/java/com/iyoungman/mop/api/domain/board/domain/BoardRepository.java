package com.iyoungman.mop.api.domain.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-06-18.
 */

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {

    //TODO
//    @Query("SELECT b.writerName FROM Board b where b.id = :id")
//    Optional<String> findWriterById(@Param("id") Long id);
}
