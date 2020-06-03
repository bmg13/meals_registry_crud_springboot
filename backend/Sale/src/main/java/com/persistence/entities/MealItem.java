package com.persistence.entities;

import com.persistence.valueObjects.IdentificationNumber;
import com.persistence.valueObjects.PointOfSale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "meal_item")
public class MealItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mealItemId;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @Column
    private IdentificationNumber identificationNumber;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date packedDate;

    @Column
    private boolean available;

    @Column
    private int quantityOfItem;

    @Column
    private PointOfSale pointOfSale;

    @Column
    private Meal meal;

    public MealItem() {
    }

    public MealItem(
            Date expirationDate,
            IdentificationNumber identificationNumber,
            Date packedDate,
            boolean available,
            int quantityOfItem,
            PointOfSale pointOfSale,
            Meal meal) {
        this.expirationDate = expirationDate;
        this.identificationNumber = identificationNumber;
        this.packedDate = packedDate;
        this.available = available;
        this.quantityOfItem = quantityOfItem;
        this.pointOfSale = pointOfSale;
        this.meal = meal;
    }

    public MealItem(
            long id,
            Date expirationDate,
            IdentificationNumber identificationNumber,
            Date packedDate,
            boolean available,
            int quantityOfItem,
            PointOfSale pointOfSale,
            Meal meal) {
        this.mealItemId = id;
        this.expirationDate = expirationDate;
        this.identificationNumber = identificationNumber;
        this.packedDate = packedDate;
        this.available = available;
        this.quantityOfItem = quantityOfItem;
        this.pointOfSale = pointOfSale;
        this.meal = meal;
    }

    public long getMealItemId() {
        return mealItemId;
    }

    public void setMealItemId(long mealItemId) {
        this.mealItemId = mealItemId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public IdentificationNumber getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(IdentificationNumber identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Date getPackedDate() {
        return packedDate;
    }

    public void setPackedDate(Date packedDate) {
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

    public PointOfSale getPointOfSale() {
        return pointOfSale;
    }

    public void setPointOfSale(PointOfSale pointOfSale) {
        this.pointOfSale = pointOfSale;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}