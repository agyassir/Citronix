package com.example.citronix.DTO;

import com.example.citronix.Entity.Harvest;
import com.example.citronix.Entity.Tree;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

@Data
public class HarvestTreeDTO {
    private UUID id ;
    private Integer quantity;
    private Tree tree;
    private Harvest harvest;
}
