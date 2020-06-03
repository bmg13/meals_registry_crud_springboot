package com.services;

import com.persistence.entities.Meal;
import com.persistence.repositories.MealRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dtos.MealDTO;
import com.mappers.MealMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealService.class);

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private NutritionDataService nutritionDataService;

    public MealDTO getSingleMeal(long mealId) {
        LOGGER.info("About to get the meal with id {} .", mealId);
        Meal meal = this.mealRepository.findById(mealId);
        LOGGER.info("Meal retrieved from db.");
        return MealMapper.mapMealToMealDTO(meal);
    }

    public MealDTO getSingleMealByDesignation(String designation) {
        LOGGER.info("About to get the meal with designation {} .", designation);
        Meal meal = this.mealRepository.findByDesignation(designation);
        LOGGER.info("Meal retrieved from db.");
        return MealMapper.mapMealToMealDTO(meal);
    }

    public List<MealDTO> getMeals() {
        LOGGER.info("About to get all meals .");
        List<Meal> allMeals = this.mealRepository.findAll();
        LOGGER.info("Meals retrieved from db.");
        final List<MealDTO> allMealsConverted = new ArrayList<>();
        allMeals.forEach(
                meal -> allMealsConverted.add(MealMapper.mapMealToMealDTO(meal)));
        LOGGER.info("Total number of meals is {} ", allMeals.size());
        return allMealsConverted;
    }

    public void createMeal(MealDTO mealDTO) {
        LOGGER.info("About to create a meal.");
        this.nutritionDataService.createNutritionData(mealDTO.getNutritionData());
        this.mealRepository.saveAndFlush(MealMapper.mapMealDTOToMeal(mealDTO));
        LOGGER.info("Meal created.");
    }

    public void updateMeal(Meal meal) {
        LOGGER.info("About to update a meal.");
        if (this.mealRepository.findByDesignation(meal.getDesignation()) != null) {
            Meal existingMeal = this.mealRepository.findByDesignation(meal.getDesignation());
            existingMeal.setAllergen(meal.getAllergen());
            existingMeal.setTypeOfFood(meal.getTypeOfFood());
            existingMeal.setPhoto(meal.getPhoto());
            existingMeal.setNutritionData(meal.getNutritionData());
            existingMeal.setIngredients(meal.getIngredients());
            existingMeal.setDesignation(meal.getDesignation());
            existingMeal.setQuantitySold(meal.getQuantitySold());
            existingMeal.setQuantityToSell(meal.getQuantityToSell());
            this.mealRepository.saveAndFlush(existingMeal);
        } else {
            this.mealRepository.saveAndFlush(meal);
        }
        LOGGER.info("Meal updated.");
    }

    public void deleteMeal(long mealId) {
        LOGGER.info("About to delete a meal.");
        this.mealRepository.deleteById(mealId);
        LOGGER.info("Meal deleted.");
    }

    public void increaseMealQuantityToSell(String designation) {
        Meal meal = this.mealRepository.findByDesignation(designation);
        if (meal != null) {
            meal.setQuantityToSell(meal.getQuantityToSell() + 1);
            this.mealRepository.save(meal);
            LOGGER.info("Added meal to sell.");
        }
    }

    public void decreaseMealQuantityToSell(String designation) {
        Meal meal = this.mealRepository.findByDesignation(designation);
        if (meal != null) {
            meal.setQuantityToSell(meal.getQuantityToSell() - 1);
            this.mealRepository.save(meal);
            LOGGER.info("Removed meal to sell.");
        }
    }
}