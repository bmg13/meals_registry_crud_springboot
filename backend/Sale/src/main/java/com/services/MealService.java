package com.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.dtos.MealDTO;

@Service
public class MealService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealService.class);

    private static final String MEALS_URI = "http://localhost:3034/api/meal";

    @Autowired
    private RestTemplate restTemplate;

    public void updateMeal(MealDTO mealDTO) {
        LOGGER.info("About to update a meal.");
        this.restTemplate.put(MEALS_URI + "/update", mealDTO);
        LOGGER.info("Meal updated.");
    }
}