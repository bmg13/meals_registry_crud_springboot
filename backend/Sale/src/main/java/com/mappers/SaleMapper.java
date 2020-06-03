package com.mappers;

import com.persistence.entities.Sale;
import com.dtos.SaleDTO;

public class SaleMapper {

    public static SaleDTO mapSaleToSaleDTO(Sale sale) {
        return new SaleDTO(
                MealItemMapper.mapMealItemToMealItemDTO(sale.getMealItem()),
                sale.getSoldDate(),
                sale.getRole());
    }

    public static Sale mapSaleDTOToSale(SaleDTO saleDTO) {
        return new Sale(
                MealItemMapper.mapMealItemDTOToMealItem(saleDTO.getMealItem()),
                saleDTO.getSoldDate(),
                saleDTO.getRole());
    }
}