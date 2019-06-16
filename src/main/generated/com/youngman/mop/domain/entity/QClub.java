package com.youngman.mop.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.myclub.domain.MyClub;
import com.youngman.mop.domain.schedule.domain.Schedule;


/**
 * QClub is a Querydsl query type for Club
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClub extends EntityPathBase<Club> {

    private static final long serialVersionUID = -382139652L;

    public static final QClub club = new QClub("club");

    public final DatePath<java.time.LocalDate> createDate = createDate("createDate", java.time.LocalDate.class);

    public final StringPath hobby = createString("hobby");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduce = createString("introduce");

    public final ListPath<MyClub, QMyClub> myClubs = this.<MyClub, QMyClub>createList("myClubs", MyClub.class, QMyClub.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath region = createString("region");

    public final ListPath<Schedule, QSchedule> schedule = this.<Schedule, QSchedule>createList("schedule", Schedule.class, QSchedule.class, PathInits.DIRECT2);

    public QClub(String variable) {
        super(Club.class, forVariable(variable));
    }

    public QClub(Path<? extends Club> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClub(PathMetadata metadata) {
        super(Club.class, metadata);
    }

}

