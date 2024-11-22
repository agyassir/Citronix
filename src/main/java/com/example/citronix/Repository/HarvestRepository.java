package com.example.citronix.Repository;

import com.example.citronix.Entity.Enums.Season;
import com.example.citronix.Entity.Field;
import com.example.citronix.Entity.Harvest;
import com.example.citronix.Repository.Criteria.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HarvestRepository extends JpaRepository<Harvest, UUID> , CustomRepository<Harvest> {
    boolean existsByFieldAndSeason(Field field, Season season);
}
