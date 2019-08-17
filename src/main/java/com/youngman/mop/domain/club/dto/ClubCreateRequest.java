package com.youngman.mop.domain.club.dto;

import com.youngman.mop.domain.club.domain.Club;
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

    private Long clubId;
    private String name;
    private String introduce;
    private String region;
    private String hobby;
    private String chairEmail;


    @Builder
    public ClubCreateRequest(Long clubId, String name, String introduce,
                             String region, String hobby, String chairEmail) {
        this.clubId = clubId;
        this.name = name;
        this.introduce = introduce;
        this.region = region;
        this.hobby = hobby;
        this.chairEmail = chairEmail;
    }

    public Club toEntity() {
        return Club.builder()
                .name(name)
                .introduce(introduce)
                .region(region)
                .hobby(hobby)
                .chairEmail(chairEmail)
                .build();
    }

}
