package com.youngman.mop.domain.schedule.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSchedule is a Querydsl query type for Schedule
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSchedule extends EntityPathBase<Schedule> {

    private static final long serialVersionUID = -1236815371L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSchedule schedule = new QSchedule("schedule");

    public final com.youngman.mop.domain.model.QBaseTime _super = new com.youngman.mop.domain.model.QBaseTime(this);

    public final com.youngman.mop.domain.club.domain.QClub club;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> meetingTime = createDateTime("meetingTime", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedTime = _super.modifiedTime;

    public final StringPath name = createString("name");

    public final ListPath<com.youngman.mop.domain.participant.domain.Participant, com.youngman.mop.domain.participant.domain.QParticipant> participants = this.<com.youngman.mop.domain.participant.domain.Participant, com.youngman.mop.domain.participant.domain.QParticipant>createList("participants", com.youngman.mop.domain.participant.domain.Participant.class, com.youngman.mop.domain.participant.domain.QParticipant.class, PathInits.DIRECT2);

    public final StringPath region = createString("region");

    public final StringPath writer = createString("writer");

    public QSchedule(String variable) {
        this(Schedule.class, forVariable(variable), INITS);
    }

    public QSchedule(Path<? extends Schedule> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSchedule(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSchedule(PathMetadata metadata, PathInits inits) {
        this(Schedule.class, metadata, inits);
    }

    public QSchedule(Class<? extends Schedule> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.club = inits.isInitialized("club") ? new com.youngman.mop.domain.club.domain.QClub(forProperty("club")) : null;
    }

}

