package com.youngman.mop.domain.entity;

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

    private static final long serialVersionUID = -1884393632L;

    public static final QMember member = new QMember("member1");

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> createDate = createDate("createDate", java.time.LocalDate.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduce = createString("introduce");

    public final StringPath mobile = createString("mobile");

    public final ListPath<MyClub, QMyClub> myClubs = this.<MyClub, QMyClub>createList("myClubs", MyClub.class, QMyClub.class, PathInits.DIRECT2);

    public final ListPath<MyHobby, QMyHobby> myHobbies = this.<MyHobby, QMyHobby>createList("myHobbies", MyHobby.class, QMyHobby.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath pw = createString("pw");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

