package com.example.citronix.Repository.Criteria.Implementation;

import com.example.citronix.Entity.HarvestTree;
import com.example.citronix.Repository.Criteria.CustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class HarvestTreeCustomRepository implements CustomRepository<HarvestTree> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HarvestTree> findAllWithCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HarvestTree> query = cb.createQuery(HarvestTree.class);
        Root<HarvestTree> root = query.from(HarvestTree.class);
        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }
}
