package com.youngman.mop.domain.participant;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QParticipant is a Querydsl query type for Participant
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParticipant extends EntityPathBase<Participant> {

    private static final long serialVersionUID = -1566709555L;

    public static final QParticipant participant = new QParticipant("participant");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Long> scheduleId = createNumber("scheduleId", Long.class);

    public QParticipant(String variable) {
        super(Participant.class, forVariable(variable));
    }

    public QParticipant(Path<? extends Participant> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParticipant(PathMetadata metadata) {
        super(Participant.class, metadata);
    }

}

