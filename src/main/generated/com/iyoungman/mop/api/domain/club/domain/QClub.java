package com.iyoungman.mop.api.domain.club.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClub is a Querydsl query type for Club
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClub extends EntityPathBase<Club> {

    private static final long serialVersionUID = -652403378L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClub club = new QClub("club");

    public final com.iyoungman.mop.api.common.model.QBaseDate _super = new com.iyoungman.mop.api.common.model.QBaseDate(this);

    public final com.iyoungman.mop.api.common.model.QAddress address;

    public final QClubChair clubChair;

    public final QClubImage clubImage;

    //inherited
    public final DatePath<java.time.LocalDate> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduce = createString("introduce");

    //inherited
    public final DatePath<java.time.LocalDate> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public QClub(String variable) {
        this(Club.class, forVariable(variable), INITS);
    }

    public QClub(Path<? extends Club> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClub(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClub(PathMetadata metadata, PathInits inits) {
        this(Club.class, metadata, inits);
    }

    public QClub(Class<? extends Club> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.iyoungman.mop.api.common.model.QAddress(forProperty("address")) : null;
        this.clubChair = inits.isInitialized("clubChair") ? new QClubChair(forProperty("clubChair")) : null;
        this.clubImage = inits.isInitialized("clubImage") ? new QClubImage(forProperty("clubImage")) : null;
    }

}

