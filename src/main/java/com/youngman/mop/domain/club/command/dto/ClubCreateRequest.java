package com.youngman.mop.domain.club.command.dto;

import com.youngman.mop.domain.club.command.domain.Club;
import com.youngman.mop.domain.club.command.domain.ClubChair;
import com.youngman.mop.domain.club.command.domain.ClubImage;
import com.youngman.mop.domain.common.model.Address;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubCreateRequest {

    private String name;
    private String introduce;
    private Address address;
    private ClubChair clubChair;
    private ClubImage clubImage;

    public ClubCreateRequest(String name, String introduce, Address address,
                             ClubChair clubChair, ClubImage clubImage) {
        this.name = name;
        this.introduce = introduce;
        this.address = address;
        this.clubChair = clubChair;
        this.clubImage = clubImage;
    }

    public Club toEntity() {
        return Club.builder()
                .name(name)
                .introduce(introduce)
                .address(address)
                .clubChair(clubChair)
                .clubImage(clubImage)
                .build();
    }

}
