package com.youngman.mop.original.club.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.original.myclub.domain.MyClub;
import com.youngman.mop.domain.schedule.domain.Schedule;


/**
 * QClub is a Querydsl query type for Club
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClub extends EntityPathBase<Club> {

    private static final long serialVersionUID = 2066205747L;

    public static final QClub club = new QClub("club");

    public final com.youngman.mop.original.model.QBaseDate _super = new com.youngman.mop.original.model.QBaseDate(this);

    public final ListPath<Board, com.youngman.mop.original.board.domain.QBoard> boards = this.<Board, com.youngman.mop.original.board.domain.QBoard>createList("boards", Board.class, com.youngman.mop.original.board.domain.QBoard.class, PathInits.DIRECT2);

    public final StringPath chairEmail = createString("chairEmail");

    //inherited
    public final DatePath<java.time.LocalDate> createdDate = _super.createdDate;

    public final StringPath hobby = createString("hobby");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imagePath = createString("imagePath");

    public final StringPath introduce = createString("introduce");

    //inherited
    public final DatePath<java.time.LocalDate> modifiedDate = _super.modifiedDate;

    public final ListPath<MyClub, com.youngman.mop.original.myclub.domain.QMyClub> myClubs = this.<MyClub, com.youngman.mop.original.myclub.domain.QMyClub>createList("myClubs", MyClub.class, com.youngman.mop.original.myclub.domain.QMyClub.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath region = createString("region");

    public final ListPath<Schedule, com.youngman.mop.original.schedule.domain.QSchedule> schedule = this.<Schedule, com.youngman.mop.original.schedule.domain.QSchedule>createList("schedule", Schedule.class, com.youngman.mop.original.schedule.domain.QSchedule.class, PathInits.DIRECT2);

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

