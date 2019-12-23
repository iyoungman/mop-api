package com.youngman.mop.domain.comment.domain;

import com.youngman.mop.board.domain.Board;
import com.youngman.mop.common.model.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Entity
@Table(name = "comment_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTime implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Long id;

	@Lob
	private String content;

	private String writer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_id", nullable = false)
	private Board board;


	@Builder
	public Comment(String content, String writer, Board board) {
		this.content = content;
		this.writer = writer;
		this.board = board;
	}
}
