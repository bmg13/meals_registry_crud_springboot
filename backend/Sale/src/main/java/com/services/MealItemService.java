package com.services;

import com.persistence.entities.MealItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.dtos.MealInstance;
import com.dtos.MealItemDTO;
import com.dtos.MealItemsDTO;
import com.mappers.MealItemMapper;

import java.util.List;

@Service
public class MealItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealItemService.class);

    private static final String MEAL_ITEMS_URI = "http://localhost:3031/api/mealinstance";
    private static final String MEALS_URI = "http://localhost:3034/api/meal";

    @Autowired
    private RestTemplate restTemplate;

    public MealItemDTO getSingleMealItem(long mealItemId) {
        LOGGER.info("About to get the meal item with id {} .", mealItemId);
        ResponseEntity<MealInstance> mealItem = this.restTemplate.exchange(MEAL_ITEMS_URI + "/" + mealItemId, HttpMethod.GET, null, MealInstance.class);
        LOGGER.info("Meal item retrieved from external service.");
        return mealItem.getBody().getMealInstance();
    }

    public List<MealItemDTO> getAllItemMeals() {
        LOGGER.info("About to get all item meals.");
        ResponseEntity<MealItemsDTO> mealItems = this.restTemplate.exchange(MEAL_ITEMS_URI, HttpMethod.GET, null, MealItemsDTO.class);
        final List<MealItemDTO> allItemMeals = mealItems.getBody().getMealsInstance();
        LOGGER.info("Total number of item meals is {} ", allItemMeals.size());
        return allItemMeals;
    }

    public List<MealItemDTO> getAvailableItemMeals() {
        LOGGER.info("About to get available item meals.");
        List<MealItemDTO> allItemMeals = getAllItemMeals();
        LOGGER.info("Total number of available item meals is {} ", allItemMeals.size());
        return allItemMeals;
    }

    public void createItemMeal(MealItemDTO mealItemDTO) {
        LOGGER.info("About to create a meal item.");
        this.restTemplate.postForObject(MEAL_ITEMS_URI, mealItemDTO, MealItemDTO.class);
        LOGGER.info("Meal item created.");
    }

    public void updateItemMeal(MealItemDTO mealItemDTO) {
        LOGGER.info("About to update a meal item.");
        this.restTemplate.put(MEAL_ITEMS_URI + "/update", mealItemDTO);
        LOGGER.info("Meal item updated.");
    }

    public void deleteItemMeal(long mealItemId) {
        MealItem mealItem = MealItemMapper.mapMealItemDTOToMealItem((getSingleMealItem(mealItemId)));
        decreaseMealQuantityToSell(mealItem);
        LOGGER.info("About to delete a meal item.");
        this.restTemplate.delete(MEAL_ITEMS_URI + "/" + mealItemId);
        LOGGER.info("Meal item deleted.");
    }

    private void decreaseMealQuantityToSell(MealItem mealItem) {
        if (mealItem != null) {
            String designation = mealItem.getMeal().getDesignation();
            this.restTemplate.put(MEALS_URI + "/quantity/remove/designation/" + designation, null);
        }
    }
}
