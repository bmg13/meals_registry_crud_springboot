package com.dtos;

import java.io.Serializable;

public class IngredientDTO implements Serializable {

    private String description;

    public IngredientDTO() {
    }

    public IngredientDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
