package com.youngman.mop.original.hobby.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHobby is a Querydsl query type for Hobby
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHobby extends EntityPathBase<Hobby> {

    private static final long serialVersionUID = -360048241L;

    public static final QHobby hobby = new QHobby("hobby");

    public final StringPath category = createString("category");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.youngman.mop.original.myhobby.domain.MyHobby, com.youngman.mop.original.myhobby.domain.QMyHobby> myHobbies = this.<com.youngman.mop.original.myhobby.domain.MyHobby, com.youngman.mop.original.myhobby.domain.QMyHobby>createList("myHobbies", com.youngman.mop.original.myhobby.domain.MyHobby.class, com.youngman.mop.original.myhobby.domain.QMyHobby.class, PathInits.DIRECT2);

    public final StringPath subCategory = createString("subCategory");

    public QHobby(String variable) {
        super(Hobby.class, forVariable(variable));
    }

    public QHobby(Path<? extends Hobby> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHobby(PathMetadata metadata) {
        super(Hobby.class, metadata);
    }

}

