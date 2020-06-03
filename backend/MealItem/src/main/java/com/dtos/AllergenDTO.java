package com.dtos;

import java.io.Serializable;

public class AllergenDTO implements Serializable {

    private String allergenName;

    private String allergenValue;

    public AllergenDTO(){

    }

    public AllergenDTO(String allergenName, String allergenValue) {
        this.allergenName = allergenName;
        this.allergenValue = allergenValue;
    }

    public String getAllergenName() {
        return allergenName;
    }

    public void setAllergenName(String allergenName) {
        this.allergenName = allergenName;
    }

    public String getAllergenValue() {
        return allergenValue;
    }

    public void setAllergenValue(String allergenValue) {
        this.allergenValue = allergenValue;
    }
}
