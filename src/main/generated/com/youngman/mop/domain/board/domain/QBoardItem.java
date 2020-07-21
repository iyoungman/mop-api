package com.youngman.mop.domain.board.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardItem is a Querydsl query type for BoardItem
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QBoardItem extends BeanPath<BoardItem> {

    private static final long serialVersionUID = 359057858L;

    public static final QBoardItem boardItem = new QBoardItem("boardItem");

    public final EnumPath<BoardType> boardType = createEnum("boardType", BoardType.class);

    public final StringPath content = createString("content");

    public final StringPath title = createString("title");

    public final StringPath writer = createString("writer");

    public QBoardItem(String variable) {
        super(BoardItem.class, forVariable(variable));
    }

    public QBoardItem(Path<? extends BoardItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardItem(PathMetadata metadata) {
        super(BoardItem.class, metadata);
    }

}

