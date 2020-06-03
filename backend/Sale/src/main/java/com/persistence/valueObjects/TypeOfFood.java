package com.persistence.valueObjects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape= JsonFormat.Shape.OBJECT)
public enum TypeOfFood {

    DESERT("Desert"),
    SOUP("Soup"),
    MAIN_DISH("Main Dish");

    private String typeOfFood;

    TypeOfFood(final String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    @JsonValue
    public String getTypeOfFood() {
        return typeOfFood;
    }
}
