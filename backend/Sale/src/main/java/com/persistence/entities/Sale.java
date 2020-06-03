package com.persistence.entities;

import com.persistence.valueObjects.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long saleId;

    @Column
    private MealItem mealItem;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date soldDate;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    public Sale() {
    }

    public Sale(MealItem mealItem, Date soldDate, Role role) {
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

    public MealItem getMealItem() {
        return mealItem;
    }

    public void setMealItem(MealItem mealItem) {
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
