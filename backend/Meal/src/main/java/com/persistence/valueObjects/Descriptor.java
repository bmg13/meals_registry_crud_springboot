package com.persistence.valueObjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class Descriptor implements Serializable {

    @Column
    private String name;

    @Column
    private double value;

    @Column
    private String unit;

    @Column
    private double maxValue;

    public Descriptor() {
    }

    public Descriptor(String name, double value, String unit, double maxValue) {
        this.name = name;
        this.value = value;
        this.unit = unit;
        this.maxValue = maxValue;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public double getMaxValue() {
        return maxValue;
    }
}
