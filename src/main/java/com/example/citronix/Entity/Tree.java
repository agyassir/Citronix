package com.example.citronix.Entity;

import com.example.citronix.Entity.Enums.TreeStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Tree {
    @Id
    private UUID id;
    private LocalDate plantingDate;
    private Integer age;
    private Double productivityRate;
    private TreeStatus status;
    private Integer number;
    @ManyToOne
    private Field field;
}
