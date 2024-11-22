package com.example.citronix.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Field {
@Id
    private UUID id;
    private Integer area;
    @OneToMany
    private List<Tree> trees;
    @ManyToOne()
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

}
