package com.mappers;

import com.persistence.entities.NutritionData;
import com.persistence.valueObjects.Descriptor;
import com.dtos.DescriptorDTO;
import com.dtos.NutritionDataDTO;

import java.util.List;

public class NutritionDataMapper {

    public static NutritionDataDTO mapNutritionDataToNutritionDataDTO(NutritionData nutritionData) {
        List<DescriptorDTO> descriptors = DescriptorMapper.mapDescriptorListToDescriptorDTOList(nutritionData.getDescriptors());
        return new NutritionDataDTO(descriptors);
    }

    public static NutritionData mapNutritionDataDTOToNutritionData(NutritionDataDTO nutritionData) {
        List<Descriptor> descriptors = DescriptorMapper.mapDescriptorListDTOToDescriptorList(nutritionData.getDescriptors());
        return new NutritionData(descriptors);
    }
}
