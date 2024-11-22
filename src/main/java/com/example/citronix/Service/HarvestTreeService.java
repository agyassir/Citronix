package com.example.citronix.Service;

import com.example.citronix.Entity.HarvestTree;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HarvestTreeService {
    HarvestTree createHarvestTree(HarvestTree harvestTree);

    Optional<HarvestTree> getHarvestTreeById(UUID id);

    List<HarvestTree> getAllHarvestTrees();

    HarvestTree updateHarvestTree(UUID id, HarvestTree harvestTree);

    void deleteHarvestTree(UUID id);
}
