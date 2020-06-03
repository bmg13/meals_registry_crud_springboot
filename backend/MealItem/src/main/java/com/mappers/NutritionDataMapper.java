package com.mappers;

import com.persistence.entities.NutritionData;
import com.persistence.valueObjects.Descriptor;
import com.dtos.DescriptorDTO;
import com.dtos.NutritionDataDTO;

import java.util.ArrayList;
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

    public static List<NutritionDataDTO> mapNutritionDataListToNutritionDataDTOList(List<NutritionData> nutritionDataList) {
        List<NutritionDataDTO> nutritionDataResult = new ArrayList<>();
        nutritionDataList.forEach(i -> nutritionDataResult.add(mapNutritionDataToNutritionDataDTO(i)));
        return nutritionDataResult;
    }

    public static List<NutritionData> mapNutritionDataListDTOToNutritionDataList(List<NutritionDataDTO> nutritionDataList) {
        List<NutritionData> nutritionDataResult = new ArrayList<>();
        nutritionDataList.forEach(i -> nutritionDataResult.add(mapNutritionDataDTOToNutritionData(i)));
        return nutritionDataResult;
    }
}
