package com.example.citronix.Service;

import com.example.citronix.DTO.FarmDto;
import com.example.citronix.Entity.Farm;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FarmService {
    Farm createFarm(FarmDto farm);

    Optional<FarmDto> getFarmById(UUID id);

    List<FarmDto> getAllFarms();

    FarmDto updateFarm(UUID id, FarmDto farm);

    void deleteFarm(UUID id);
}
