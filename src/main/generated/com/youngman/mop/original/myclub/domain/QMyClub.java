package com.youngman.mop.original.myclub.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyClub is a Querydsl query type for MyClub
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyClub extends EntityPathBase<MyClub> {

    private static final long serialVersionUID = -1562109781L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyClub myClub = new QMyClub("myClub");

    public final com.youngman.mop.original.model.QBaseDate _super = new com.youngman.mop.original.model.QBaseDate(this);

    public final com.youngman.mop.original.club.domain.QClub club;

    //inherited
    public final DatePath<java.time.LocalDate> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.youngman.mop.original.member.domain.QMember member;

    //inherited
    public final DatePath<java.time.LocalDate> modifiedDate = _super.modifiedDate;

    public QMyClub(String variable) {
        this(MyClub.class, forVariable(variable), INITS);
    }

    public QMyClub(Path<? extends MyClub> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyClub(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyClub(PathMetadata metadata, PathInits inits) {
        this(MyClub.class, metadata, inits);
    }

    public QMyClub(Class<? extends MyClub> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.club = inits.isInitialized("club") ? new com.youngman.mop.original.club.domain.QClub(forProperty("club")) : null;
        this.member = inits.isInitialized("member") ? new com.youngman.mop.original.member.domain.QMember(forProperty("member")) : null;
    }

}

