package com.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.persistence.entities.MealItem;

@Repository
@Transactional
public interface MealItemRepository extends JpaRepository<MealItem, Long> {

    MealItem findById(long mealItemId);

}
