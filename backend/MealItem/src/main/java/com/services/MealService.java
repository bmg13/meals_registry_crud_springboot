package com.services;

import com.persistence.entities.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.dtos.MealDTO;
import com.dtos.MealsDTO;
import com.mappers.MealMapper;

@Service
public class MealService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealService.class);

    private static final String MEALS_URI = "http://localhost:3034/api/meal";

    @Autowired
    private RestTemplate restTemplate;

    public MealDTO getSingleMeal(long mealId) {
        LOGGER.info("About to get the meal with id {} .", mealId);
        return getSingleMealFromExternalService(mealId);
    }

    public MealsDTO getMeals() {
        LOGGER.info("About to get all meals .");
        return getAllMealsFromExternalService();
    }

    public void createMeal(MealDTO mealDTO) {
        createMealFromExternalService(mealDTO);
    }

    public void updateMeal(Meal meal) {
        updateMealFromExternalService(MealMapper.mapMealToMealDTO(meal));
    }

    private MealsDTO getAllMealsFromExternalService() {
        LOGGER.info("About to get all meals from the Meal service.");
        ResponseEntity<MealsDTO> response = this.restTemplate.exchange(
                MEALS_URI,
                HttpMethod.GET,
                null,
                MealsDTO.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            LOGGER.error("Response: {}, ", response);
        }

        return response.getBody();
    }

    private MealDTO getSingleMealFromExternalService(long id) {
        LOGGER.info("About to get single meal from the Meal service.");
        ResponseEntity<MealDTO> response = this.restTemplate.exchange("url", HttpMethod.GET, null, MealDTO.class, id);
        if (!response.getStatusCode().is2xxSuccessful()) {
            LOGGER.error("Response: {}, ", response);
        }

        return response.getBody();
    }

    private MealDTO createMealFromExternalService(MealDTO mealDTO) {
        LOGGER.info("About to create single meal from the Meal service.");
        ResponseEntity<MealDTO> response = this.restTemplate.postForObject(
                "url",
                mealDTO,
                null,
                MealDTO.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            LOGGER.error("Response: {}, ", response);
        }

        return response.getBody();
    }

    private void updateMealFromExternalService(MealDTO mealDTO) {
        LOGGER.info("About to update single meal from the Meal service.");
        this.restTemplate.put(
                "url",
                mealDTO,
                null,
                MealDTO.class);
    }
}