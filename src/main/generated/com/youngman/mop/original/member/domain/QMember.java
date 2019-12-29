package com.youngman.mop.original.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.original.myclub.domain.MyClub;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1674150149L;

    public static final QMember member = new QMember("member1");

    public final com.youngman.mop.original.model.QBaseDate _super = new com.youngman.mop.original.model.QBaseDate(this);

    public final StringPath address = createString("address");

    //inherited
    public final DatePath<java.time.LocalDate> createdDate = _super.createdDate;

    public final StringPath email = createString("email");

    public final StringPath fcmToken = createString("fcmToken");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduce = createString("introduce");

    public final StringPath mobile = createString("mobile");

    //inherited
    public final DatePath<java.time.LocalDate> modifiedDate = _super.modifiedDate;

    public final ListPath<MyClub, com.youngman.mop.original.myclub.domain.QMyClub> myClubs = this.<MyClub, com.youngman.mop.original.myclub.domain.QMyClub>createList("myClubs", MyClub.class, com.youngman.mop.original.myclub.domain.QMyClub.class, PathInits.DIRECT2);

    public final ListPath<com.youngman.mop.original.myhobby.domain.MyHobby, com.youngman.mop.original.myhobby.domain.QMyHobby> myHobbies = this.<com.youngman.mop.original.myhobby.domain.MyHobby, com.youngman.mop.original.myhobby.domain.QMyHobby>createList("myHobbies", com.youngman.mop.original.myhobby.domain.MyHobby.class, com.youngman.mop.original.myhobby.domain.QMyHobby.class, PathInits.DIRECT2);

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

