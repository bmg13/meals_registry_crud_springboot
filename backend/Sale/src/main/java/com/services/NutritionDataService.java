package com.services;

import com.persistence.entities.NutritionData;
import com.persistence.repositories.NutritionDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mappers.NutritionDataMapper;
import com.dtos.NutritionDataDTO;

@Service
public class NutritionDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NutritionDataService.class);

    @Autowired
    private NutritionDataRepository nutritionDataRepository;

    public NutritionData getSingleNutritionData(long nutritionDataId) {
        return this.nutritionDataRepository.findById(nutritionDataId);
    }

    public void createNutritionData(NutritionDataDTO nutritionDataDTO) {
        LOGGER.info("About to add a nutrition data.");
        this.nutritionDataRepository.saveAndFlush(
                NutritionDataMapper.mapNutritionDataDTOToNutritionData(nutritionDataDTO));
        LOGGER.info("Nutrition data added.");
    }
}
