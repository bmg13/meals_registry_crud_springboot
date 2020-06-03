package com.dtos;

import java.io.Serializable;

public class MealItemDTO implements Serializable {

    private String id;
    private String expirationDate;
    private IdentificationNumberDTO identificationNumber;
    private String packedDate;
    private boolean available;
    private PointOfSaleDTO location;
    private MealDTO mealId;
    private int quantityOfItem;

    public MealItemDTO() {
    }

    public MealItemDTO(
            String expirationDate,
            IdentificationNumberDTO identificationNumber,
            String packedDate,
            boolean available,
            int quantityOfItem,
            PointOfSaleDTO location,
            MealDTO mealId) {
        this.expirationDate = expirationDate;
        this.identificationNumber = identificationNumber;
        this.packedDate = packedDate;
        this.available = available;
        this.quantityOfItem = quantityOfItem;
        this.location = location;
        this.mealId = mealId;
    }

    public MealItemDTO(
            String id,
            String expirationDate,
            IdentificationNumberDTO identificationNumber,
            String packedDate,
            boolean available,
            int quantityOfItem,
            PointOfSaleDTO location,
            MealDTO mealId) {
        this.id = id;
        this.expirationDate = expirationDate;
        this.identificationNumber = identificationNumber;
        this.packedDate = packedDate;
        this.available = available;
        this.quantityOfItem = quantityOfItem;
        this.location = location;
        this.mealId = mealId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public IdentificationNumberDTO getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(IdentificationNumberDTO identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPackedDate() {
        return packedDate;
    }

    public void setPackedDate(String packedDate) {
        this.packedDate = packedDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getQuantityOfItem() {
        return quantityOfItem;
    }

    public void setQuantityOfItem(int quantityOfItem) {
        this.quantityOfItem = quantityOfItem;
    }

    public PointOfSaleDTO getLocation() {
        return location;
    }

    public void setLocation(PointOfSaleDTO location) {
        this.location = location;
    }

    public MealDTO getMealId() {
        return mealId;
    }

    public void setMealId(MealDTO mealId) {
        this.mealId = mealId;
    }
}
