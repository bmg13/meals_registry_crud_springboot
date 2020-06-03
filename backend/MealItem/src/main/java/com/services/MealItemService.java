package com.services;

import com.mappers.DateMapper;
import com.persistence.entities.MealItem;
import com.persistence.repositories.MealItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.dtos.MealItemDTO;
import com.mappers.MealItemMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealItemService.class);

    private static final String MEALS_URI = "http://localhost:3034/api/meal";

    @Autowired
    private MealItemRepository mealItemRepository;

    @Autowired
    private MealService mealService;

    @Autowired
    private RestTemplate restTemplate;

    public MealItemDTO getSingleMealItem(long mealItemId) {
        LOGGER.info("About to get the meal item with id {} .", mealItemId);
        MealItem mealItem = this.mealItemRepository.findById(mealItemId);
        LOGGER.info("Meal item retrieved from db.");
        return MealItemMapper.mapMealItemToMealItemDTO(mealItem);
    }

    public List<MealItemDTO> getAllItemMeals() {
        this.mealService.getMeals();
        LOGGER.info("About to get all item meals.");
        List<MealItem> allItemMeals = this.mealItemRepository.findAll();
        checkIfExpired(allItemMeals);
        LOGGER.info("Item Meals retrieved from db.");
        final List<MealItemDTO> allItemMealsConverted = new ArrayList<>();
        allItemMeals
                .parallelStream()
                .forEach(
                        mealItem -> allItemMealsConverted.add(MealItemMapper.mapMealItemToMealItemDTO(mealItem)));
        LOGGER.info("Total number of item meals is {} ", allItemMeals.size());
        return allItemMealsConverted;
    }

    public List<MealItemDTO> getAvailableItemMeals() {
        LOGGER.info("About to get available item meals.");
        List<MealItemDTO> allItemMeals = getAllItemMeals();
        List<MealItemDTO> availableItemMeals = retrieveAvailableItemMeals(allItemMeals);
        LOGGER.info("Total number of available item meals is {} ", availableItemMeals.size());
        return availableItemMeals;
    }

    public void createItemMeal(MealItemDTO mealItemDTO) {
        LOGGER.info("About to create a meal item.");
        MealItem mealItem = MealItemMapper.mapMealItemDTOToMealItem(mealItemDTO);
        this.mealItemRepository.saveAndFlush(mealItem);
        LOGGER.info("Meal item created.");
        increaseMealQuantityToSell(mealItem);
    }

    public void updateItemMeal(MealItemDTO mealItemDTO) {
        LOGGER.info("About to update a meal item.");
        this.mealItemRepository.saveAndFlush(MealItemMapper.mapMealItemDTOToMealItem(mealItemDTO));
        LOGGER.info("Meal item updated.");
    }

    public void deleteItemMeal(long mealItemId) {
        decreaseMealQuantityToSell(this.mealItemRepository.findById(mealItemId));
        LOGGER.info("About to delete a meal item.");
        this.mealItemRepository.deleteById(mealItemId);
        LOGGER.info("Meal item deleted.");
    }

    private void increaseMealQuantityToSell(MealItem mealItem) {
        if (mealItem != null) {
            String designation = mealItem.getMeal().getDesignation();
            this.restTemplate.put(MEALS_URI + "/quantity/add/designation/" + designation, null);
        }
    }

    private void decreaseMealQuantityToSell(MealItem mealItem) {
        if (mealItem != null) {
            String designation = mealItem.getMeal().getDesignation();
            this.restTemplate.put(MEALS_URI + "/quantity/remove/designation/" + designation, null);
        }
    }

    private void checkIfExpired(List<MealItem> allMealItems) {
        if (allMealItems != null && allMealItems.size() > 0) {
            allMealItems.forEach(mealItem -> {
                if (mealItem.getExpirationDate().before(DateMapper.retrieveLimitExpirationDate())) {
                    mealItem.setAvailable(false);
                    this.mealItemRepository.saveAndFlush(mealItem);
                }
            });
        }
    }

    private List<MealItemDTO> retrieveAvailableItemMeals(List<MealItemDTO> allItemMeals) {
        List<MealItemDTO> availableItemMeals = new ArrayList<>();
        if (allItemMeals != null && allItemMeals.size() > 0) {
            allItemMeals
                    .parallelStream()
                    .forEach(
                            mealItem -> {
                                if (mealItem.isAvailable()) {
                                    availableItemMeals.add(mealItem);
                                }
                            }
                    );
        }

        return availableItemMeals;
    }
}
