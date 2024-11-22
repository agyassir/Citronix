package com.example.citronix.Entity;

import com.example.citronix.Entity.Enums.Season;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Harvest {
    @Id
    private UUID id;
    private Season season;
    private LocalDate date;
    private Integer totalQuantity;
    @ManyToOne
    private Field field;
    @OneToMany
    private List<HarvestTree> harvestTrees;

}
