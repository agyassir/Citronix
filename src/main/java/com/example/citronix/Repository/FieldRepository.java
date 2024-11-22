package com.example.citronix.Repository;

import com.example.citronix.Entity.Field;
import com.example.citronix.Repository.Criteria.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FieldRepository extends JpaRepository<Field, UUID>, CustomRepository<Field> {
}
