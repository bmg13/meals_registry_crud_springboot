package com.persistence.valueObjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IdentificationNumber implements Serializable {

    @Column
    private String identificationNumber;

    public IdentificationNumber() {
    }

    public IdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }
}
