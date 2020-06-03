package com.dtos;

import java.util.List;

public class MealsDTO {

    private List<MealDTO> meals;

    public MealsDTO() {
    }

    public MealsDTO(List<MealDTO> meals) {
        this.meals = meals;
    }

    public List<MealDTO> getMeals() {
        return meals;
    }

    public void setMeals(List<MealDTO> meals) {
        this.meals = meals;
    }
}
