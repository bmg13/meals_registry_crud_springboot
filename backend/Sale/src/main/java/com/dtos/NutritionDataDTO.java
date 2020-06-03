package com.dtos;

import java.io.Serializable;
import java.util.List;

public class NutritionDataDTO implements Serializable {

    private List<DescriptorDTO> descriptors;

    private String nutritionDataId;

    public NutritionDataDTO() {
    }

    public NutritionDataDTO(List<DescriptorDTO> descriptors) {
        this.descriptors = descriptors;
    }

    public String getNutritionDataId() {
        return nutritionDataId;
    }

    public void setNutritionDataId(String nutritionDataId) {
        this.nutritionDataId = nutritionDataId;
    }

    public List<DescriptorDTO> getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(List<DescriptorDTO> descriptors) {
        this.descriptors = descriptors;
    }
}
