package com.example.citronix.DTO;

import com.example.citronix.Entity.Enums.Season;
import com.example.citronix.Entity.Field;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class HarvestDTO {
    private UUID id;
    private Season season;
    private LocalDate date;
    private Integer totalQuantity;
    private Field field;
}
