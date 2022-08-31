package com.example.babystore.model.entity.enums;

public enum ColorEnum {
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    PINK("Pink");

    private final String value;

    ColorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
