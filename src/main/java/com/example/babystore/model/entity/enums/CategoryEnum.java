package com.example.babystore.model.entity.enums;

public enum CategoryEnum {
    STROLLERS("Strollers"),
    CAR_SEATS("Car Seats"),
    BABY_CLOTHES("Baby Clothes"),
    BABY_COSMETICS("Baby Cosmetics"),
    TOYS("Toys"),
    BREAST_MILK_PUMPS("Breast Milk Pumps"),
    MATERNITY_CLOTHES("Maternity Clothes"),
    MOMMY_COSMETICS("Mommy Cosmetics"),
    MILK_CONTAINERS("Milk Containers");

    private final String value;

    CategoryEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
