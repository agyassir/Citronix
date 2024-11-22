package com.example.citronix.Repository;

import com.example.citronix.Entity.Tree;
import com.example.citronix.Repository.Criteria.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TreeRepository extends JpaRepository<Tree, UUID> , CustomRepository<Tree> {
}