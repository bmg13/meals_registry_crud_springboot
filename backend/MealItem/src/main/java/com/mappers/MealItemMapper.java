package com.mappers;

import com.persistence.entities.MealItem;
import com.dtos.IdentificationNumberDTO;
import com.dtos.MealItemDTO;

public class MealItemMapper {

    public static MealItemDTO mapMealItemToMealItemDTO(MealItem mealItem) {
        return new MealItemDTO(
                String.valueOf(mealItem.getMealItemId()),
                DateMapper.convertDateInDateToStringFormatted(mealItem.getExpirationDate()),
                IdentificationNumberMapper.mapIdentificationNumberToIdentificationNumberDTO(mealItem.getIdentificationNumber()),
                DateMapper.convertDateInDateToStringFormatted(mealItem.getPackedDate()),
                mealItem.isAvailable(),
                mealItem.getQuantityOfItem(),
                PointOfSaleMapper.mapPointOfSaleToPointOfSaleDTO(mealItem.getPointOfSale()),
                MealMapper.mapMealToMealDTO(mealItem.getMeal()));
    }

    public static MealItem mapMealItemDTOToMealItem(MealItemDTO mealItemDTO) {
        if (mealItemDTO.getIdentificationNumber().getDescription() == null) {
            mealItemDTO.setIdentificationNumber(new IdentificationNumberDTO(mealItemDTO.getPackedDate()));
        }
        if (mealItemDTO.getId() == null || mealItemDTO.getId().isEmpty()) {
            return new MealItem(
                    DateMapper.convertStringFormatted(mealItemDTO.getExpirationDate()),
                    IdentificationNumberMapper.mapIdentificationNumberDTOToIdentificationNumber(mealItemDTO.getIdentificationNumber()),
                    DateMapper.convertStringFormatted(mealItemDTO.getPackedDate()),
                    mealItemDTO.isAvailable(),
                    mealItemDTO.getQuantityOfItem(),
                    PointOfSaleMapper.mapPointOfSaleDTOToPointOfSale(mealItemDTO.getLocation()),
                    MealMapper.mapMealDTOToMeal(mealItemDTO.getMealId()));
        }
        return new MealItem(
                Long.parseLong(mealItemDTO.getId()),
                DateMapper.convertStringFormatted(mealItemDTO.getExpirationDate()),
                IdentificationNumberMapper.mapIdentificationNumberDTOToIdentificationNumber(mealItemDTO.getIdentificationNumber()),
                DateMapper.convertStringFormatted(mealItemDTO.getPackedDate()),
                mealItemDTO.isAvailable(),
                mealItemDTO.getQuantityOfItem(),
                PointOfSaleMapper.mapPointOfSaleDTOToPointOfSale(mealItemDTO.getLocation()),
                MealMapper.mapMealDTOToMeal(mealItemDTO.getMealId()));
    }
}