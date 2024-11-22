package com.example.citronix.Service.Implementation;

import com.example.citronix.Entity.Field;
import com.example.citronix.Entity.Harvest;
import com.example.citronix.Repository.HarvestRepository;
import com.example.citronix.Service.HarvestService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class HarvestServiceImpl implements HarvestService {
    private HarvestRepository harvestRepository;

    @Override
    public Harvest createHarvest(Harvest harvest) {
        Field field = harvest.getField();

        boolean hasExistingHarvest = harvestRepository.existsByFieldAndSeason(field, harvest.getSeason());

        if (hasExistingHarvest) {
            throw new RuntimeException("This field already has a harvest for the specified season.");
        }
        return harvestRepository.save(harvest);
    }

    @Override
    public Optional<Harvest> getHarvestById(UUID id) {

        return harvestRepository.findById(id);
    }

    @Override
    public List<Harvest> getAllHarvests() {

        return harvestRepository.findAll();
    }

    @Override
    public Harvest updateHarvest(UUID id, Harvest harvest) {

        return harvestRepository.findById(id).map(existingHarvest -> {
            existingHarvest.setSeason(harvest.getSeason());
            existingHarvest.setDate(harvest.getDate());
            existingHarvest.setTotalQuantity(harvest.getTotalQuantity());
            return harvestRepository.save(existingHarvest);
        }).orElseThrow(() -> new RuntimeException("Harvest not found"));
    }

    @Override
    public void deleteHarvest(UUID id) {
        harvestRepository.deleteById(id);
    }
}
