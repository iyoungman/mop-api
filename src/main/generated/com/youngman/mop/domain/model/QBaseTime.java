package com.youngman.mop.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.youngman.mop.domain.generic.time.BaseTime;


/**
 * QBaseTime is a Querydsl query type for BaseTime
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QBaseTime extends EntityPathBase<BaseTime> {

    private static final long serialVersionUID = 1202339566L;

    public static final QBaseTime baseTime = new QBaseTime("baseTime");

    public final DateTimePath<java.time.LocalDateTime> createdTime = createDateTime("createdTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedTime = createDateTime("modifiedTime", java.time.LocalDateTime.class);

    public QBaseTime(String variable) {
        super(BaseTime.class, forVariable(variable));
    }

    public QBaseTime(Path<? extends BaseTime> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseTime(PathMetadata metadata) {
        super(BaseTime.class, metadata);
    }

}

