package com.example.citronix.Service.Implementation;

import com.example.citronix.Entity.Enums.Season;
import com.example.citronix.Entity.Harvest;
import com.example.citronix.Entity.HarvestTree;
import com.example.citronix.Entity.Tree;
import com.example.citronix.Repository.HarvestTreeRepository;
import com.example.citronix.Service.HarvestTreeService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class HarvestTreeServiceImpl implements HarvestTreeService {
    private HarvestTreeRepository harvestTreeRepository;

    @Override
    public HarvestTree createHarvestTree(HarvestTree harvestTree) {
        Tree tree = harvestTree.getTree();
        Harvest harvest = harvestTree.getHarvest();

        int harvestYear = harvest.getDate().getYear();
        Season harvestSeason = harvest.getSeason();

        boolean treeAlreadyHarvested = harvestTreeRepository.existsByTreeAndHarvestSeasonAndYear(
                tree, harvestSeason, harvestYear);

        if (treeAlreadyHarvested) {
            throw new RuntimeException("This tree is already included in a harvest for the same season.");
        }

        return harvestTreeRepository.save(harvestTree);
    }

    @Override
    public Optional<HarvestTree> getHarvestTreeById(UUID id) {

        return harvestTreeRepository.findById(id);
    }

    @Override
    public List<HarvestTree> getAllHarvestTrees() {

        return harvestTreeRepository.findAll();
    }

    @Override
    public HarvestTree updateHarvestTree(UUID id, HarvestTree harvestTree) {

        return harvestTreeRepository.findById(id).map(existingHarvestTree -> {
            existingHarvestTree.setQuantity(harvestTree.getQuantity());
            existingHarvestTree.setTree(harvestTree.getTree());
            existingHarvestTree.setHarvest(harvestTree.getHarvest());
            return harvestTreeRepository.save(existingHarvestTree);
        }).orElseThrow(() -> new RuntimeException("HarvestTree not found"));
    }

    @Override
    public void deleteHarvestTree(UUID id) {

        harvestTreeRepository.deleteById(id);
    }

}
