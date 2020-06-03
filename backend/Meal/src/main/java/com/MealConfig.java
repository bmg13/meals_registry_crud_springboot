package com;

import com.persistence.valueObjects.TypeOfFood;
import com.services.MealService;
import com.services.NutritionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.dtos.AllergenDTO;
import com.dtos.DescriptorDTO;
import com.dtos.IngredientDTO;
import com.dtos.MealDTO;
import com.dtos.NutritionDataDTO;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MealConfig {

    private List<MealDTO> meals;
    private List<IngredientDTO> ingredients;
    private NutritionDataDTO nutritionData;

    @Autowired
    private MealService mealService;

    @Autowired
    private NutritionDataService nutritionDataService;

    @PostConstruct
    public void createDefaultMeals() {
        createMealsList();
        this.mealService.createMeal(this.meals.get(0));
    }

    private void createMealsList() {
        createIngredientsList();
        createNutritionData();
        this.meals = new ArrayList<>();
        MealDTO meal1 = new MealDTO(
                this.nutritionData,
                10,
                TypeOfFood.SOUP,
                "photo",
                this.ingredients,
                "Caldo Verde",
                12,
                new ArrayList<AllergenDTO>());

        MealDTO meal2 = new MealDTO(
                this.nutritionData,
                4,
                TypeOfFood.MAIN_DISH,
                "photo",
                this.ingredients,
                "Francesinha",
                1,
                new ArrayList<AllergenDTO>());
        MealDTO meal3 = new MealDTO(
                this.nutritionData,
                31,
                TypeOfFood.DESERT,
                "photo",
                this.ingredients,
                "Mousse de chocolate",
                14,
                new ArrayList<AllergenDTO>());
        this.meals.add(meal1);
        this.meals.add(meal2);
        this.meals.add(meal3);
    }

    private void createIngredientsList() {
        this.ingredients = new ArrayList<>();
        IngredientDTO ingredient1 =
                new IngredientDTO("batata");
        IngredientDTO ingredient2 =
                new IngredientDTO("agua");
        IngredientDTO ingredient3 =
                new IngredientDTO("queijo derretido");
        this.ingredients.add(ingredient1);
        this.ingredients.add(ingredient2);
        this.ingredients.add(ingredient3);
    }

    private void createNutritionData() {
        List<DescriptorDTO> descriptors = new ArrayList<>();
        DescriptorDTO descriptor1 = new DescriptorDTO("caldo verde", 10, "boa sopa", 20);
        DescriptorDTO descriptor2 = new DescriptorDTO("francesinha", 15, "bom molho", 30);
        DescriptorDTO descriptor3 = new DescriptorDTO("mousse", 55, "chocolate", 66);
        descriptors.add(descriptor1);
        descriptors.add(descriptor2);
        descriptors.add(descriptor3);
        this.nutritionData = new NutritionDataDTO(descriptors);
        this.nutritionDataService.createNutritionData(this.nutritionData);
    }
}