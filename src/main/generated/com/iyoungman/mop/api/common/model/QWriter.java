package com.iyoungman.mop.api.common.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWriter is a Querydsl query type for Writer
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QWriter extends BeanPath<Writer> {

    private static final long serialVersionUID = -1702089993L;

    public static final QWriter writer = new QWriter("writer");

    public final NumberPath<Long> writerId = createNumber("writerId", Long.class);

    public final StringPath writerName = createString("writerName");

    public QWriter(String variable) {
        super(Writer.class, forVariable(variable));
    }

    public QWriter(Path<? extends Writer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWriter(PathMetadata metadata) {
        super(Writer.class, metadata);
    }

}

