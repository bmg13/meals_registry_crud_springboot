package com.mappers;

import com.persistence.valueObjects.Ingredient;
import com.dtos.IngredientDTO;

import java.util.ArrayList;
import java.util.List;

public class IngredientMapper {

    public static IngredientDTO mapIngredientToIngredientDTO(Ingredient ingredient) {
        return new IngredientDTO(ingredient.getDescription());
    }

    public static Ingredient mapIngredientDTOToIngredient(IngredientDTO ingredientDTO) {
        return new Ingredient(ingredientDTO.getDescription());
    }

    public static List<IngredientDTO> mapIngredientListToIngredientDTOList(List<Ingredient> ingredientList) {
        List<IngredientDTO> ingredientResult = new ArrayList<>();
        ingredientList.forEach(i -> ingredientResult.add(mapIngredientToIngredientDTO(i)));
        return ingredientResult;
    }

    public static List<Ingredient> mapIngredientListDTOToIngredientList(List<IngredientDTO> ingredientList) {
        List<Ingredient> ingredientResult = new ArrayList<>();
        ingredientList.forEach(i -> ingredientResult.add(mapIngredientDTOToIngredient(i)));
        return ingredientResult;
    }
}
