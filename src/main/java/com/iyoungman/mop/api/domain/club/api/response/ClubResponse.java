package com.iyoungman.mop.api.domain.club.api.response;

import com.iyoungman.mop.api.common.model.Address;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-07-19.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubResponse {

    private Long clubId;

    private String name;

    private String introduce;

    private LocalDate createDate;

    private Address address;

    private String hobby;

    private String imageUri;

    public ClubResponse(Long clubId, String name, String introduce, LocalDate createDate,
            Address address, String hobby, String imageUri) {
        this.clubId = clubId;
        this.name = name;
        this.introduce = introduce;
        this.createDate = createDate;
        this.address = address;
        this.hobby = hobby;
        this.imageUri = imageUri;
    }
}
