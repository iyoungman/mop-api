package com.youngman.mop.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.youngman.mop.domain.generic.time.BaseDate;


/**
 * QBaseDate is a Querydsl query type for BaseDate
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QBaseDate extends EntityPathBase<BaseDate> {

    private static final long serialVersionUID = 1201855439L;

    public static final QBaseDate baseDate = new QBaseDate("baseDate");

    public final DatePath<java.time.LocalDate> createdDate = createDate("createdDate", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> modifiedDate = createDate("modifiedDate", java.time.LocalDate.class);

    public QBaseDate(String variable) {
        super(BaseDate.class, forVariable(variable));
    }

    public QBaseDate(Path<? extends BaseDate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseDate(PathMetadata metadata) {
        super(BaseDate.class, metadata);
    }

}

