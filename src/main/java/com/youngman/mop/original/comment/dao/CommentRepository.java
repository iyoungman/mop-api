package com.youngman.mop.original.comment.dao;

import com.youngman.mop.original.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-06-20.
 */

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
