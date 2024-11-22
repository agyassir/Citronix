package com.example.citronix.Repository.Criteria.Implementation;

import com.example.citronix.Entity.Client;
import com.example.citronix.Repository.Criteria.CustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ClientCustomRepository implements CustomRepository<Client> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> findAllWithCriteria() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = cb.createQuery(Client.class);
        Root<Client> root = query.from(Client.class);
        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }
}
