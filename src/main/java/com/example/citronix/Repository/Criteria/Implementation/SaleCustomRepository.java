package com.example.citronix.Repository.Criteria.Implementation;

import com.example.citronix.Entity.Sale;
import com.example.citronix.Repository.Criteria.CustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class SaleCustomRepository implements CustomRepository<Sale> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Sale> findAllWithCriteria() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sale> query = cb.createQuery(Sale.class);
        Root<Sale> root = query.from(Sale.class);
        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }
}
