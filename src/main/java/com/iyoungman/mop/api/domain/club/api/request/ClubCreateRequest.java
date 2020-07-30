package com.iyoungman.mop.api.domain.club.api.request;

import com.iyoungman.mop.api.common.model.Address;
import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.club.domain.ClubChair;
import com.iyoungman.mop.api.domain.club.domain.ClubImage;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Builder
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
