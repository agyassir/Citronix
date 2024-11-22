package com.example.citronix.Repository.Criteria.Implementation;

import com.example.citronix.Entity.Field;
import com.example.citronix.Repository.Criteria.CustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class FieldCustomRepository implements CustomRepository<Field> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Field> findAllWithCriteria() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Field> query = cb.createQuery(Field.class);
        Root<Field> root = query.from(Field.class);
        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }
}
