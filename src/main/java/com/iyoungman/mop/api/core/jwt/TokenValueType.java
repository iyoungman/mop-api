package com.iyoungman.mop.api.core.jwt;

public enum TokenValueType {

    ID("id"),
    EMAIL("email"),
    NAME("name");

    private String value;

    TokenValueType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
