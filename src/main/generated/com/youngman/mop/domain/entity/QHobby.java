package com.youngman.mop.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import com.youngman.mop.domain.hobby.domain.Hobby;
import com.youngman.mop.domain.myhobby.domain.MyHobby;


/**
 * QHobby is a Querydsl query type for Hobby
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHobby extends EntityPathBase<Hobby> {

    private static final long serialVersionUID = 1043261516L;

    public static final QHobby hobby = new QHobby("hobby");

    public final StringPath category = createString("category");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<MyHobby, QMyHobby> myHobbies = this.<MyHobby, QMyHobby>createList("myHobbies", MyHobby.class, QMyHobby.class, PathInits.DIRECT2);

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

