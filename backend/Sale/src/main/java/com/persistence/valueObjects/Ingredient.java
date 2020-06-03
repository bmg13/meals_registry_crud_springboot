package com.persistence.valueObjects;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Ingredient implements Serializable {

    private String description;

    public Ingredient() {
    }

    public Ingredient(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
