package com.example.citronix.DTO;

import com.example.citronix.Entity.Enums.TreeStatus;
import com.example.citronix.Entity.Field;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.UUID;

public class TreeDTO {
    private UUID id;
    private LocalDate plantingDate;
    private Integer age;
    private Double productivityRate;
    private TreeStatus status;
    private Integer number;
    private Field field;
}
