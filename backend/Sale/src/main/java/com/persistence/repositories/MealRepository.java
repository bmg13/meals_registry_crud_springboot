package com.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.persistence.entities.Meal;

@Repository
@Transactional
public interface MealRepository extends JpaRepository<Meal, Long> {

    Meal findById(long mealId);

    Meal findByDesignation (String designation);
}
