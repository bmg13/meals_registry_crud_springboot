package com.mappers;

import com.persistence.entities.Meal;
import com.dtos.MealDTO;

public class MealMapper {

    public static MealDTO mapMealToMealDTO(Meal meal) {
        return new MealDTO(
                meal.getMealId(),
                NutritionDataMapper.mapNutritionDataToNutritionDataDTO(meal.getNutritionData()),
                meal.getQuantityToSell(),
                meal.getTypeOfFood(),
                meal.getPhoto(),
                IngredientMapper.mapIngredientListToIngredientDTOList(meal.getIngredients()),
                meal.getDesignation(),
                meal.getQuantitySold(),
                AllergenMapper.mapAllergenListToAllergenDTOList(meal.getAllergen()));
    }

    public static Meal mapMealDTOToMeal(MealDTO mealDTO) {
        return new Meal(
                NutritionDataMapper.mapNutritionDataDTOToNutritionData(mealDTO.getNutritionData()),
                mealDTO.getQuantityToSell(),
                mealDTO.getTypeOfFood(),
                mealDTO.getPhoto(),
                IngredientMapper.mapIngredientListDTOToIngredientList(mealDTO.getIngredients()),
                mealDTO.getDesignation(),
                mealDTO.getQuantitySold(),
                AllergenMapper.mapAllegernListDTOToAllergenList(mealDTO.getAllergen()));
    }
}
