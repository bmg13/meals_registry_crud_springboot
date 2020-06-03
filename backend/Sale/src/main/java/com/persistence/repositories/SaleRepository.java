package com.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.persistence.entities.Sale;

@Repository
@Transactional
public interface SaleRepository extends JpaRepository<Sale, Long> {

    Sale findById(long saleId);
}
