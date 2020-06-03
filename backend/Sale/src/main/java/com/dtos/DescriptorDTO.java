package com.dtos;

import java.io.Serializable;

public class DescriptorDTO implements Serializable {

    private String name;
    private double value;
    private String unit;
    private double maxValue;

    public DescriptorDTO() {
    }

    public DescriptorDTO(String name, double value, String unit, double maxValue) {
        this.name = name;
        this.value = value;
        this.unit = unit;
        this.maxValue = maxValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }
}
