package com.example.citronix.Repository;

import com.example.citronix.Entity.Sale;
import com.example.citronix.Repository.Criteria.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, UUID>, CustomRepository<Sale> {
}
