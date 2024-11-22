package com.example.citronix.Repository;

import com.example.citronix.Entity.Client;
import com.example.citronix.Repository.Criteria.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID>, CustomRepository<Client> {
}
