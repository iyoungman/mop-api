package com.youngman.mop.myclub.domain;

import com.youngman.mop.common.model.BaseDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by YoungMan on 2019-05-12.
 */

@Entity
@Table(name = "my_club_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyClub extends BaseDate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_club_id")
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "club_id")
    private Long clubId;

    @Builder
    public MyClub(Long memberId, Long clubId) {
        this.memberId = memberId;
        this.clubId = clubId;
    }

//    public static MyClub of(Member member, Club club) {
//        return MyClub.builder()
//                .member(member)
//                .club(club)
//                .build();
//    }

}
