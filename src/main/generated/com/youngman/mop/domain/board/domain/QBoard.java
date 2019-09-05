package com.youngman.mop.domain.board.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import com.youngman.mop.board.domain.Board;
import com.youngman.mop.board.domain.BoardType;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = -2084734449L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final com.youngman.mop.domain.model.QBaseTime _super = new com.youngman.mop.domain.model.QBaseTime(this);

    public final EnumPath<BoardType> boardType = createEnum("boardType", BoardType.class);

    public final com.youngman.mop.domain.club.domain.QClub club;

    public final ListPath<com.youngman.mop.domain.comment.domain.Comment, com.youngman.mop.domain.comment.domain.QComment> comments = this.<com.youngman.mop.domain.comment.domain.Comment, com.youngman.mop.domain.comment.domain.QComment>createList("comments", com.youngman.mop.domain.comment.domain.Comment.class, com.youngman.mop.domain.comment.domain.QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedTime = _super.modifiedTime;

    public final StringPath title = createString("title");

    public final StringPath writer = createString("writer");

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.club = inits.isInitialized("club") ? new com.youngman.mop.domain.club.domain.QClub(forProperty("club")) : null;
    }

}

