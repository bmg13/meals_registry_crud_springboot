package com.dtos;

import com.persistence.valueObjects.TypeOfFood;

import java.io.Serializable;
import java.util.List;

public class MealDTO implements Serializable {

    private long id;
    private NutritionDataDTO nutritionData;
    private int quantityToSell;
    private TypeOfFood typeOfFood;
    private int quantitySold;
    private String designation;
    private List<IngredientDTO> ingredients;

    private String photo;
    private List<AllergenDTO> allergen;

    public MealDTO() {
    }

    public MealDTO(
            NutritionDataDTO nutritionData,
            int quantityToSell,
            TypeOfFood typeOfFood,
            String photo,
            List<IngredientDTO> ingredients,
            String designation,
            int quantitySold,
            List<AllergenDTO> allergen) {
        this.nutritionData = nutritionData;
        this.quantityToSell = quantityToSell;
        this.typeOfFood = typeOfFood;
        this.photo = photo;
        this.ingredients = ingredients;
        this.designation = designation;
        this.quantitySold = quantitySold;
        this.allergen = allergen;
    }

    public MealDTO(
            long id,
            NutritionDataDTO nutritionData,
            int quantityToSell,
            TypeOfFood typeOfFood,
            String photo,
            List<IngredientDTO> ingredients,
            String designation,
            int quantitySold,
            List<AllergenDTO> allergen) {
        this.nutritionData = nutritionData;
        this.quantityToSell = quantityToSell;
        this.typeOfFood = typeOfFood;
        this.photo = photo;
        this.ingredients = ingredients;
        this.designation = designation;
        this.quantitySold = quantitySold;
        this.allergen = allergen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NutritionDataDTO getNutritionData() {
        return nutritionData;
    }

    public void setNutritionData(NutritionDataDTO nutritionData) {
        this.nutritionData = nutritionData;
    }

    public int getQuantityToSell() {
        return quantityToSell;
    }

    public void setQuantityToSell(int quantityToSell) {
        this.quantityToSell = quantityToSell;
    }

    public TypeOfFood getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(TypeOfFood typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public List<AllergenDTO> getAllergen() {
        return allergen;
    }

    public void setAllergen(List<AllergenDTO> allergen) {
        this.allergen = allergen;
    }
}
