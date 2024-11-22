package com.example.citronix.DTO;

import com.example.citronix.Entity.Farm;
import com.example.citronix.Entity.Tree;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
import java.util.UUID;


@Builder
@Data
public class FieldDTO {
    @NotNull

    private UUID id;
    private Double area;
    private List<Tree> trees;
    private Farm farm;
}
