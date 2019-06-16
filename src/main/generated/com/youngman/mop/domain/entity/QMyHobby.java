package com.youngman.mop.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import com.youngman.mop.domain.myhobby.domain.MyHobby;


/**
 * QMyHobby is a Querydsl query type for MyHobby
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyHobby extends EntityPathBase<MyHobby> {

    private static final long serialVersionUID = -2042830976L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyHobby myHobby = new QMyHobby("myHobby");

    public final QHobby hobby;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public QMyHobby(String variable) {
        this(MyHobby.class, forVariable(variable), INITS);
    }

    public QMyHobby(Path<? extends MyHobby> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyHobby(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyHobby(PathMetadata metadata, PathInits inits) {
        this(MyHobby.class, metadata, inits);
    }

    public QMyHobby(Class<? extends MyHobby> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hobby = inits.isInitialized("hobby") ? new QHobby(forProperty("hobby")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

