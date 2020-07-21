package com.youngman.mop.domain.myclub.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMyClub is a Querydsl query type for MyClub
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyClub extends EntityPathBase<MyClub> {

    private static final long serialVersionUID = -1562109781L;

    public static final QMyClub myClub = new QMyClub("myClub");

    public final com.youngman.mop.common.model.QBaseDate _super = new com.youngman.mop.common.model.QBaseDate(this);

    public final NumberPath<Long> clubId = createNumber("clubId", Long.class);

    //inherited
    public final DatePath<java.time.LocalDate> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    //inherited
    public final DatePath<java.time.LocalDate> modifiedDate = _super.modifiedDate;

    public QMyClub(String variable) {
        super(MyClub.class, forVariable(variable));
    }

    public QMyClub(Path<? extends MyClub> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMyClub(PathMetadata metadata) {
        super(MyClub.class, metadata);
    }

}

