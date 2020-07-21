package com.youngman.mop.domain.club.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QClubImage is a Querydsl query type for ClubImage
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QClubImage extends BeanPath<ClubImage> {

    private static final long serialVersionUID = -585722648L;

    public static final QClubImage clubImage = new QClubImage("clubImage");

    public final StringPath imagePath = createString("imagePath");

    public QClubImage(String variable) {
        super(ClubImage.class, forVariable(variable));
    }

    public QClubImage(Path<? extends ClubImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClubImage(PathMetadata metadata) {
        super(ClubImage.class, metadata);
    }

}

