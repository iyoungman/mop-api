package com.iyoungman.mop.api.domain.member.api.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSignInRequest {

    private String email;

    private String pw;

    @Builder
    public MemberSignInRequest(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }
}
