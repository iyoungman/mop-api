package com.iyoungman.mop.api.domain.myclub.api.dto;

import com.iyoungman.mop.api.domain.myclub.domain.MyClub;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyClubCreateRequest {

    private Long memberId;
    private Long clubId;

    @Builder
    public MyClubCreateRequest(Long memberId, Long clubId) {
        this.memberId = memberId;
        this.clubId = clubId;
    }

    public MyClub toEntity() {
        return MyClub.builder()
                .memberId(memberId)
                .clubId(clubId)
                .build();
    }
}
