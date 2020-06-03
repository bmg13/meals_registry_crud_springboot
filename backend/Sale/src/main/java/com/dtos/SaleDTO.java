package com.dtos;

import com.persistence.valueObjects.Role;

import java.io.Serializable;
import java.util.Date;

public class SaleDTO implements Serializable {

    private MealItemDTO mealItem;
    private Date soldDate;
    private Role role;


    private long saleId;

    public SaleDTO() {
    }

    public SaleDTO(MealItemDTO mealItem, Date soldDate, Role role) {
        this.mealItem = mealItem;
        this.soldDate = soldDate;
        this.role = role;
    }

    public long getSaleId() {
        return saleId;
    }

    public void setSaleId(long saleId) {
        this.saleId = saleId;
    }

    public MealItemDTO getMealItem() {
        return mealItem;
    }

    public void setMealItem(MealItemDTO mealItem) {
        this.mealItem = mealItem;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
