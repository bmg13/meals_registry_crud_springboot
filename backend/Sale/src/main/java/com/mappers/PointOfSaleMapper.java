package com.mappers;

import com.persistence.valueObjects.PointOfSale;
import com.dtos.PointOfSaleDTO;

public class PointOfSaleMapper {

    public static PointOfSaleDTO mapPointOfSaleToPointOfSaleDTO(PointOfSale pointOfSale) {
        return new PointOfSaleDTO(
                pointOfSale.getPointOfSaleId(),
                pointOfSale.getBuilding(),
                pointOfSale.getFloor(),
                pointOfSale.getRoom(),
                pointOfSale.getOpensAt(),
                pointOfSale.getClosesAt(),
                DateMapper.convertDateInDateToStringFormatted(pointOfSale.getDownTimeStart()),
                DateMapper.convertDateInDateToStringFormatted(pointOfSale.getDownTimeEnd()),
                pointOfSale.isState());
    }

    public static PointOfSale mapPointOfSaleDTOToPointOfSale(PointOfSaleDTO pointOfSaleDTO) {
        if (pointOfSaleDTO != null) {
            return new PointOfSale(
                    pointOfSaleDTO.getPointOfSaleId(),
                    pointOfSaleDTO.getBuilding(),
                    pointOfSaleDTO.getFloor(),
                    pointOfSaleDTO.getRoom(),
                    pointOfSaleDTO.getOpensAt(),
                    pointOfSaleDTO.getClosesAt(),
                    DateMapper.convertStringFormatted(pointOfSaleDTO.getDownTimeStart()),
                    DateMapper.convertStringFormatted(pointOfSaleDTO.getDownTimeEnd()),
                    pointOfSaleDTO.isState());
        }
        return null;
    }
}