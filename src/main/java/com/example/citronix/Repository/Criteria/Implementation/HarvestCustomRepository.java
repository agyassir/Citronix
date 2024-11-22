package com.example.citronix.Repository.Criteria.Implementation;

import com.example.citronix.Entity.Harvest;
import com.example.citronix.Repository.Criteria.CustomRepository;

import java.util.List;

public class HarvestCustomRepository implements CustomRepository<Harvest> {
    @Override
    public List<Harvest> findAllWithCriteria() {
        return List.of();
    }
}
