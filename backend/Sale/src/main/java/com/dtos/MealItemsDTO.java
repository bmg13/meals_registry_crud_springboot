package com.dtos;

import java.util.List;

public class MealItemsDTO {

    private List<MealItemDTO> mealsInstance;

    public MealItemsDTO() {
    }

    public MealItemsDTO(List<MealItemDTO> mealsInstance) {
        this.mealsInstance = mealsInstance;
    }

    public List<MealItemDTO> getMealsInstance() {
        return mealsInstance;
    }

    public void setMealsInstance(List<MealItemDTO> mealsInstance) {
        this.mealsInstance = mealsInstance;
    }
}
