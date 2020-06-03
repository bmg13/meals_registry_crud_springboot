package com.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.persistence.entities.PointOfSale;

@Repository
@Transactional
public interface PointOfSaleRepository extends JpaRepository<PointOfSale, Long> {

    PointOfSale findById(long pointOfSaleId);

}
