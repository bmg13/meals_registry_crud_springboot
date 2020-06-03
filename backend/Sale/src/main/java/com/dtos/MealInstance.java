package com.dtos;

public class MealInstance {

    private MealItemDTO mealInstance;

    public MealInstance() {
    }

    public MealInstance(MealItemDTO mealInstance) {
        this.mealInstance = mealInstance;
    }

    public MealItemDTO getMealInstance() {
        return mealInstance;
    }

    public void setMealInstance(MealItemDTO mealInstance) {
        this.mealInstance = mealInstance;
    }
}
