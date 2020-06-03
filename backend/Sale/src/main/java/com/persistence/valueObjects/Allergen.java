package com.persistence.valueObjects;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Allergen implements Serializable {

    private String allergenName;

    private String allergenValue;

    public Allergen(){
    }

    public Allergen(String allergenName, String allergenValue) {

        this.allergenName = allergenName;
        this.allergenValue = allergenValue;
    }

    public String getAllergenName() {
        return allergenName;
    }

    public String getAllergenValue() {
        return allergenValue;
    }
}
