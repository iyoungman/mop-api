package com.youngman.mop.domain.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1674150149L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final com.youngman.mop.common.model.QBaseDate _super = new com.youngman.mop.common.model.QBaseDate(this);

    public final com.youngman.mop.common.model.QAddress address;

    //inherited
    public final DatePath<java.time.LocalDate> createdDate = _super.createdDate;

    public final StringPath email = createString("email");

    public final QFcmToken fcmToken;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduce = createString("introduce");

    public final StringPath mobile = createString("mobile");

    //inherited
    public final DatePath<java.time.LocalDate> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final QPassword password;

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.youngman.mop.common.model.QAddress(forProperty("address")) : null;
        this.fcmToken = inits.isInitialized("fcmToken") ? new QFcmToken(forProperty("fcmToken")) : null;
        this.password = inits.isInitialized("password") ? new QPassword(forProperty("password")) : null;
    }

}

