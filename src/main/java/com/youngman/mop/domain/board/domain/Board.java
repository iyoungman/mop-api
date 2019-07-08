package com.youngman.mop.domain.board.domain;

import com.youngman.mop.domain.board.dto.BoardCreateRequest;
import com.youngman.mop.domain.board.dto.BoardUpdateRequest;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.comment.domain.Comment;
import com.youngman.mop.domain.model.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Entity
@Table(name = "board_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTime implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_id")
	private Long id;

	private String title;

	@Lob
	private String content;

	private String writer;

	@Enumerated(EnumType.STRING)
	private BoardType boardType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "club_id", nullable = false)
	private Club club;

//	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<>();


	@Builder
	public Board(String title, String content, String writer,
				 BoardType boardType, Club club, List<Comment> comments) {

		this.title = title;
		this.content = content;
		this.writer = writer;
		this.boardType = boardType;
		this.club = club;
		this.comments = comments;
	}

	public static Board of(BoardCreateRequest boardCreateRequest, Club club) {
		return Board.builder()
				.title(boardCreateRequest.getTitle())
				.content(boardCreateRequest.getContent())
				.writer(boardCreateRequest.getWriter())
				.boardType(boardCreateRequest.getBoardType())
				.club(club)
				.build();
	}

	public void updateBoard(BoardUpdateRequest boardUpdateRequest) {
		this.title = boardUpdateRequest.getTitle();
		this.content = boardUpdateRequest.getContent();
	}
}
