package com.example.citronix.Repository.Criteria.Implementation;

import com.example.citronix.Entity.Tree;
import com.example.citronix.Repository.Criteria.CustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class TreeCustomRepository implements CustomRepository<Tree> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tree> findAllWithCriteria() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tree> query = cb.createQuery(Tree.class);
        Root<Tree> root = query.from(Tree.class);
        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }
}
