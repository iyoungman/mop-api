package com.youngman.mop.domain.myclub.domain;

import com.youngman.mop.domain.common.model.BaseDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by iyoungman on 2020-06-16.
 */

@Entity
@Table(name = "my_club_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyClub extends BaseDate {

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

    public void validate(MyClubValidator myClubValidator) {
        myClubValidator.validate();
    }
}
