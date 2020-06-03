package com.dtos;

import java.util.List;

public class PointsOfSaleDTO {

    private List<PointOfSaleDTO> pointOfSaleDTOS;

    public PointsOfSaleDTO() {
    }

    public PointsOfSaleDTO(List<PointOfSaleDTO> pointOfSaleDTOS) {
        this.pointOfSaleDTOS = pointOfSaleDTOS;
    }

    public List<PointOfSaleDTO> getPointOfSaleDTOS() {
        return pointOfSaleDTOS;
    }

    public void setPointOfSaleDTOS(List<PointOfSaleDTO> pointOfSaleDTOS) {
        this.pointOfSaleDTOS = pointOfSaleDTOS;
    }
}
