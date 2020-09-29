package com.promotion.engine.util;

public enum PromotionalMethodEnum {

    DIRECT("DIRECT"),
    PERCENTAGE("PERCENTAGE");

    String code;

    PromotionalMethodEnum(String code) {
        this.code = code;
    }


    public String getPromotionalMethod() {
        return this.code;
    }
}
