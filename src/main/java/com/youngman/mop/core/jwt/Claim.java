package com.youngman.mop.core.jwt;

import lombok.Getter;

import java.util.Map;

/**
 * Created by YoungMan on 2020-02-29.
 */

@Getter
public class Claim {

    private String email;
    private String name;

    public Claim(Map<String, Object> claimMap) {
        this.email = (String) claimMap.get(TokenValueType.EMAIL.getValue());
        this.name = (String) claimMap.get(TokenValueType.NAME.getValue());
    }
}
