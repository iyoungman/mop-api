package com.iyoungman.mop.api.core.jwt;

import java.util.Map;
import lombok.Getter;

/**
 * Created by YoungMan on 2020-02-29.
 */

@Getter
public class Claim {

    private Long id;

    private String email;

    private String name;

    public Claim(Map<String, Object> claimMap) {
        this.id = (Long) claimMap.get(TokenValueType.ID.getValue());
        this.email = (String) claimMap.get(TokenValueType.EMAIL.getValue());
        this.name = (String) claimMap.get(TokenValueType.NAME.getValue());
    }

    public void check(String email, String name) {
        if (!this.email.equals(email) || !this.name.equals(name)) {
            throw new RuntimeException();
        }
    }
}
