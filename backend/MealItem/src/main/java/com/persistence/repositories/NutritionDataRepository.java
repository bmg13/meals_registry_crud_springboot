package com.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.persistence.entities.NutritionData;

public interface NutritionDataRepository extends JpaRepository<NutritionData, Long> {

    NutritionData findById(long nutritionDataId);
}
