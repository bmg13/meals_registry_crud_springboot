package com.persistence.entities;

import com.persistence.valueObjects.Allergen;
import com.persistence.valueObjects.Ingredient;
import com.persistence.valueObjects.TypeOfFood;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Meal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mealId;

    @Column
    private NutritionData nutritionData;

    @Column
    private int quantityToSell;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfFood typeOfFood;

    @Column
    private String photo;

    @Column
    @ElementCollection
    private List<Ingredient> ingredients;

    @Column(unique = true)
    private String designation;

    @Column
    private int quantitySold;

    @Column
    @ElementCollection
    private List<Allergen> allergen;

    public Meal() {
    }

    public Meal(
            long mealId,
            NutritionData nutritionData,
            int quantityToSell,
            TypeOfFood typeOfFood,
            String photo,
            List<Ingredient> ingredients,
            String designation,
            int quantitySold,
            List<Allergen> allergen) {
        this.mealId = mealId;
        this.nutritionData = nutritionData;
        this.quantityToSell = quantityToSell;
        this.typeOfFood = typeOfFood;
        this.photo = photo;
        this.ingredients = ingredients;
        this.designation = designation;
        this.quantitySold = quantitySold;
        this.allergen = allergen;
    }

    public Meal(
            NutritionData nutritionData,
            int quantityToSell,
            TypeOfFood typeOfFood,
            String photo,
            List<Ingredient> ingredients,
            String designation,
            int quantitySold,
            List<Allergen> allergen) {
        this.nutritionData = nutritionData;
        this.quantityToSell = quantityToSell;
        this.typeOfFood = typeOfFood;
        this.photo = photo;
        this.ingredients = ingredients;
        this.designation = designation;
        this.quantitySold = quantitySold;
        this.allergen = allergen;
    }

    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
        this.mealId = mealId;
    }

    public NutritionData getNutritionData() {
        return nutritionData;
    }

    public void setNutritionData(NutritionData nutritionData) {
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
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

    public List<Allergen> getAllergen() {
        return allergen;
    }

    public void setAllergen(List<Allergen> allergen) {
        this.allergen = allergen;
    }
}
