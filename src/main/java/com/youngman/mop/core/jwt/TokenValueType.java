package com.youngman.mop.core.jwt;

public enum TokenValueType {

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
