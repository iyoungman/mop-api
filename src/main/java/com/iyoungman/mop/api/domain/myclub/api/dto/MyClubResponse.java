package com.iyoungman.mop.api.domain.myclub.api.dto;

import com.iyoungman.mop.api.domain.club.domain.Club;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyClubResponse {

    private Long clubId;
    private String name;
    private String introduce;
    private LocalDate createDate;
    private String region;
    private String hobby;
    private String imageUri;
    private LocalDateTime upComingMeetingDate;

    @Builder
    public MyClubResponse(Club club, LocalDateTime upComingMeetingDate) {
        this.clubId = club.getId();
        this.name = club.getName();
        this.introduce = club.getIntroduce();
        this.upComingMeetingDate = upComingMeetingDate;
    }

//    @Builder
//    public MyClubResponse(Long clubId, String name, String introduce,
//                          LocalDate createDate, String region, String hobby,
//                          String imageUri, LocalDateTime upComingMeetingDate) {
//        this.clubId = clubId;
//        this.name = name;
//        this.introduce = introduce;
//        this.createDate = createDate;
//        this.region = region;
//        this.hobby = hobby;
//        this.imageUri = imageUri;
//        this.upComingMeetingDate = upComingMeetingDate;
//    }


}
