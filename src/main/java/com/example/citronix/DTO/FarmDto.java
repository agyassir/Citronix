package com.example.citronix.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
public class FarmDto {
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String Location;
    @NotBlank
    @Min(1000)
    private Integer area;
}
