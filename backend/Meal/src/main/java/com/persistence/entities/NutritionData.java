package com.persistence.entities;

import com.persistence.valueObjects.Descriptor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "nutrition_data")
public class NutritionData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nutritionDataId;

    //@OneToMany(targetEntity = Descriptor.class, fetch = FetchType.EAGER)
    @ElementCollection
    private List<Descriptor> descriptors;

    public NutritionData() {
    }

    public NutritionData(List<Descriptor> descriptors) {
        this.descriptors = descriptors;
    }

    public long getNutritionDataId() {
        return nutritionDataId;
    }

    public void setNutritionDataId(long nutritionDataId) {
        this.nutritionDataId = nutritionDataId;
    }

    public List<Descriptor> getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(List<Descriptor> descriptors) {
        this.descriptors = descriptors;
    }
}
