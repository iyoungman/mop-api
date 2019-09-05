package com.youngman.mop.club.domain;

import com.youngman.mop.club.controller.ClubCreateRequest;
import com.youngman.mop.domain.generic.time.BaseDate;
import com.youngman.mop.myclub.domain.MyClub;
import com.youngman.mop.domain.schedule.domain.Schedule;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-08.
 */

@Entity
@Table(name = "club_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Club extends BaseDate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;

    private String name;

    private String introduce;

    private String region;

    private String hobby;

    private String chairEmail;

    private String imagePath;

    @Builder
    public Club(String name, String introduce, String region,
                String hobby, String chairEmail) {
        this.name = name;
        this.introduce = introduce;
        this.region = region;
        this.hobby = hobby;
        this.chairEmail = chairEmail;
    }

    public void updateClub(ClubCreateRequest clubCreateRequest) {
        this.name = clubCreateRequest.getName();
        this.introduce = clubCreateRequest.getIntroduce();
        this.region = clubCreateRequest.getRegion();
        this.hobby = clubCreateRequest.getHobby();
        this.chairEmail = clubCreateRequest.getChairEmail();
    }

    public void updateClubImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
