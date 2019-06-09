package com.youngman.mop.domain.entity;

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

    private static final long serialVersionUID = -1867164344L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyClub myClub = new QMyClub("myClub");

    public final QClub club;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

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
        this.club = inits.isInitialized("club") ? new QClub(forProperty("club")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

