package com.iyoungman.mop.api.domain.member.api.dto;

import com.iyoungman.mop.api.common.model.Address;
import com.iyoungman.mop.api.domain.member.domain.FcmToken;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.iyoungman.mop.api.domain.member.domain.Password;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * Created by YoungMan on 2019-05-23.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCreateRequest {

    private String email;

    private String pw;

    private String name;

    private String mobile;

    private String address;

    private String fcmToken;

    @Builder
    public MemberCreateRequest(String email, String pw, String name,
            String mobile, String address, String fcmToken) {
        this.email = email;
        this.pw = pw;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.fcmToken = fcmToken;
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(new Password(pw))
                .name(name)
                .mobile(mobile)
                .address(new Address(address, address, address))
                .fcmToken(new FcmToken(fcmToken))
                .build();
    }
}
