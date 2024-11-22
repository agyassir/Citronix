package com.example.citronix.Service;

import com.example.citronix.Entity.Harvest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HarvestService {
    Harvest createHarvest(Harvest harvest);

    Optional<Harvest> getHarvestById(UUID id);

    List<Harvest> getAllHarvests();

    Harvest updateHarvest(UUID id, Harvest harvest);

    void deleteHarvest(UUID id);
}
