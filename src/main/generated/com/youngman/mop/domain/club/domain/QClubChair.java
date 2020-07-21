package com.youngman.mop.domain.club.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QClubChair is a Querydsl query type for ClubChair
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QClubChair extends BeanPath<ClubChair> {

    private static final long serialVersionUID = -591412654L;

    public static final QClubChair clubChair = new QClubChair("clubChair");

    public final NumberPath<Long> chairManId = createNumber("chairManId", Long.class);

    public final NumberPath<Long> viceChairManId = createNumber("viceChairManId", Long.class);

    public QClubChair(String variable) {
        super(ClubChair.class, forVariable(variable));
    }

    public QClubChair(Path<? extends ClubChair> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClubChair(PathMetadata metadata) {
        super(ClubChair.class, metadata);
    }

}

