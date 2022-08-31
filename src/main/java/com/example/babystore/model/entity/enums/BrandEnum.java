package com.example.babystore.model.entity.enums;

public enum BrandEnum {
    LORELLY("Lorelly"),
    CHIPOLINO("Chippolino"),
    KIKKABOO("Kikka Boo");

    private final String value;


    BrandEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
