package com.youngman.mop.club.command.dto;

import com.youngman.mop.club.command.domain.Club;
import com.youngman.mop.club.command.domain.ClubAddress;
import com.youngman.mop.club.command.domain.ClubChair;
import com.youngman.mop.club.command.domain.ClubImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-23.
 * Update : clubId
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubCreateRequest {

    private String name;
    private String introduce;
    private ClubAddress clubAddress;
    private ClubChair clubChair;
    private ClubImage clubImage;

    public ClubCreateRequest(String name, String introduce, ClubAddress clubAddress,
                             ClubChair clubChair, ClubImage clubImage) {
        this.name = name;
        this.introduce = introduce;
        this.clubAddress = clubAddress;
        this.clubChair = clubChair;
        this.clubImage = clubImage;
    }

    public Club toEntity() {
        return Club.builder()
                .name(name)
                .introduce(introduce)
                .clubAddress(clubAddress)
                .clubChair(clubChair)
                .clubImage(clubImage)
                .build();
    }

}
