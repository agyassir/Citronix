package com.example.citronix.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class HarvestTree {
    @Id
    private UUID id ;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "tree_id", nullable = false)
    private Tree tree;
    @ManyToOne
    @JoinColumn(name = "harvest_id", nullable = false)
    private Harvest harvest;
}
