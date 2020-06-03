package com.dtos;

import java.util.List;

public class SalesDTO {

    private List<SaleDTO> sales;

    public SalesDTO() {
    }

    public SalesDTO(List<SaleDTO> sales) {
        this.sales = sales;
    }

    public List<SaleDTO> getSales() {
        return sales;
    }

    public void setSales(List<SaleDTO> sales) {

        this.sales = sales;
    }
}
