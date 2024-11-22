package com.example.citronix.Repository.Criteria;

import com.example.citronix.Entity.Farm;

import java.util.List;

public interface CustomRepository<T> {
    public List<T> findAllWithCriteria();
}
