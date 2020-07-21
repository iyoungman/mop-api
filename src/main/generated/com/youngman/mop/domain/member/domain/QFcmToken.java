package com.youngman.mop.domain.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFcmToken is a Querydsl query type for FcmToken
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QFcmToken extends BeanPath<FcmToken> {

    private static final long serialVersionUID = 652030122L;

    public static final QFcmToken fcmToken1 = new QFcmToken("fcmToken1");

    public final StringPath fcmToken = createString("fcmToken");

    public QFcmToken(String variable) {
        super(FcmToken.class, forVariable(variable));
    }

    public QFcmToken(Path<? extends FcmToken> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFcmToken(PathMetadata metadata) {
        super(FcmToken.class, metadata);
    }

}

