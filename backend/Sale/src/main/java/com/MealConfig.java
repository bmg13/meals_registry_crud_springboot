package com;

import com.mappers.DateMapper;
import com.persistence.valueObjects.Role;
import com.persistence.valueObjects.TypeOfFood;
import com.services.MealItemService;
import com.services.MealService;
import com.services.NutritionDataService;
import com.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.dtos.AllergenDTO;
import com.dtos.DescriptorDTO;
import com.dtos.IdentificationNumberDTO;
import com.dtos.IngredientDTO;
import com.dtos.MealDTO;
import com.dtos.MealItemDTO;
import com.dtos.NutritionDataDTO;
import com.dtos.PointOfSaleDTO;
import com.dtos.SaleDTO;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MealConfig {

    private List<MealDTO> meals;
    private List<IngredientDTO> ingredients;
    private NutritionDataDTO nutritionData;
    private List<MealItemDTO> mealItems;
    private List<SaleDTO> sales;
    private List<PointOfSaleDTO> pointOfSales;

    @Autowired
    private MealService mealService;

    @Autowired
    private NutritionDataService nutritionDataService;

    @Autowired
    private MealItemService mealItemService;

    @Autowired
    private SaleService saleService;

    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder builder) {
        return builder.build();
    }

    @PostConstruct
    public void createDefaultMeals() {
        createMealsList();
        createMealItemsList();
        createSalesList();
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
        DescriptorDTO descriptor1 = new DescriptorDTO("caldo verde", 10, "L", 72);
        DescriptorDTO descriptor2 = new DescriptorDTO("francesinha", 12, "g", 50);
        DescriptorDTO descriptor3 = new DescriptorDTO("mousse", 2, "L", 90);
        descriptors.add(descriptor1);
        descriptors.add(descriptor2);
        descriptors.add(descriptor3);
        this.nutritionData = new NutritionDataDTO(descriptors);
        this.nutritionDataService.createNutritionData(this.nutritionData);
    }

    private void createMealItemsList() {
        this.mealItems = new ArrayList<>();
        createPointsOfSale();
        MealItemDTO mealItem1 = new MealItemDTO(
                DateMapper.currentDateInStringFormatted(),
                new IdentificationNumberDTO("I1"),
                DateMapper.currentDateInStringFormatted(),
                true,
                23,
                this.pointOfSales.get(0),
                this.meals.get(0));
        MealItemDTO mealItem2 = new MealItemDTO(
                DateMapper.currentDateInStringFormatted(),
                new IdentificationNumberDTO("I2"),
                DateMapper.currentDateInStringFormatted(),
                true,
                77,
                this.pointOfSales.get(1),
                this.meals.get(1));
        MealItemDTO mealItem3 = new MealItemDTO(
                DateMapper.currentDateInStringFormatted(),
                new IdentificationNumberDTO("I3"),
                DateMapper.currentDateInStringFormatted(),
                true,
                202,
                this.pointOfSales.get(2),
                this.meals.get(2));
        this.mealItems.add(mealItem1);
        this.mealItems.add(mealItem2);
        this.mealItems.add(mealItem3);
    }

    public void createPointsOfSale() {
        this.pointOfSales = new ArrayList<>();
        PointOfSaleDTO pointOfSale1 = new PointOfSaleDTO(
                1,
                "Edficio A",
                "Piso 0",
                "Sala 001",
                "08:00",
                "20:00",
                "20/12/2019",
                "01/01/2020",
                true);
        PointOfSaleDTO pointOfSale2 = new PointOfSaleDTO(
                2,
                "Edficio B",
                "Piso 1",
                "Sala 110",
                "08:00",
                "17:00",
                "20/12/2019",
                "01/01/2020",
                true);
        PointOfSaleDTO pointOfSale3 = new PointOfSaleDTO(
                3,
                "Edficio C",
                "Piso 2",
                "Sala 220",
                "08:00",
                "19:00",
                "20/12/2019",
                "01/01/2020",
                true);
        this.pointOfSales.add(pointOfSale1);
        this.pointOfSales.add(pointOfSale2);
        this.pointOfSales.add(pointOfSale3);
    }

    private void createSalesList() {
        this.sales = new ArrayList<>();
        SaleDTO sale1 = new SaleDTO(this.mealItems.get(0), DateMapper.currentDateFormatted(), Role.STUDENT);
        SaleDTO sale2 = new SaleDTO(this.mealItems.get(1), DateMapper.currentDateFormatted(), Role.OTHER);
        SaleDTO sale3 = new SaleDTO(this.mealItems.get(2), DateMapper.currentDateFormatted(), Role.STUDENT);
        this.sales.add(sale1);
        this.sales.add(sale2);
        this.sales.add(sale3);
    }
}