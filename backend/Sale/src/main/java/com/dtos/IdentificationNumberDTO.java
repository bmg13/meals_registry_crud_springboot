package com.dtos;

import java.io.Serializable;

public class IdentificationNumberDTO implements Serializable {

    private String description;

    public IdentificationNumberDTO() {
    }

    public IdentificationNumberDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
