package com.example.citronix.Controller.vm.Farm;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

import java.time.LocalDate;

public class FarmRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String Location;
    @NotBlank
    @Min(1000)
    private Integer area;


}
