package com.example.citronix.Repository.Criteria.Implementation;

import com.example.citronix.Entity.Farm;
import com.example.citronix.Repository.Criteria.CustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FarmCustomRepositoryImpl implements CustomRepository<Farm> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Farm> findAllWithCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Farm> query = cb.createQuery(Farm.class);
        Root<Farm> root = query.from(Farm.class);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

    public List<Farm> searchFarms(String location, Integer minArea, Integer maxArea) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Farm> query = cb.createQuery(Farm.class);
        Root<Farm> root = query.from(Farm.class);

        List<Predicate> predicates = new ArrayList<>();

        if (location != null) {
            predicates.add(cb.equal(root.get("location"), location));
        }
        if (minArea != null && maxArea != null) {
            predicates.add(cb.between(root.get("area"), minArea, maxArea));
        } else if (minArea != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("area"), minArea));
        } else if (maxArea != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("area"), maxArea));
        }

        query.select(root).where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
