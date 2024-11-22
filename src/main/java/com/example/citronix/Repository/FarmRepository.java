package com.example.citronix.Repository;

import com.example.citronix.Entity.Farm;
import com.example.citronix.Repository.Criteria.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FarmRepository extends JpaRepository<Farm, UUID>, CustomRepository<Farm> {
}
