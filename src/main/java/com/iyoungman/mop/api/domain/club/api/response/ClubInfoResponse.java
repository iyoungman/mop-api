package com.iyoungman.mop.api.domain.club.api.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by YoungMan on 2019-05-30.
 */

@Getter
@NoArgsConstructor
public class ClubInfoResponse implements Serializable {

    private ClubInfo clubInfo;

    private List<MemberInfo> memberInfos = new ArrayList<>();


    @Builder
    public ClubInfoResponse(ClubInfo clubInfo, List<MemberInfo> memberInfos) {
        this.clubInfo = clubInfo;
        this.memberInfos = memberInfos;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ClubInfo implements Serializable {
        private Long clubId;
        private String name;
        private String introduce;
        private LocalDate createDate;
        private String region;
        private String hobby;
        private String imageUri;

        @Builder
        public ClubInfo(Long clubId, String name, String introduce,
                        LocalDate createDate, String region, String hobby, String imageUri) {
            this.clubId = clubId;
            this.name = name;
            this.introduce = introduce;
            this.createDate = createDate;
            this.region = region;
            this.hobby = hobby;
            this.imageUri = imageUri;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class MemberInfo implements Serializable {
        private Long memberId;
        private String email;
        private String name;
        private String mobile;
        private String hobby;
        private String introduce;

        @Builder
        public MemberInfo(Long memberId, String email, String name,
                String mobile, String hobby, String introduce) {
            this.memberId = memberId;
            this.email = email;
            this.name = name;
            this.mobile = mobile;
            this.hobby = hobby;
            this.introduce = introduce;
        }
    }

}
