package com.example.citronix.Service.Implementation;

import com.example.citronix.Entity.Tree;
import com.example.citronix.Repository.TreeRepository;
import com.example.citronix.Service.TreeService;
import com.example.citronix.Util.Checker.Checker;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class TreeServiceImpl implements TreeService {
    private TreeRepository treeRepository;
    private Checker checker;

    @Override
    public Tree createTree(Tree tree) {
                checker.treeCheck(tree);
        return treeRepository.save(tree);

    }

    @Override
    public Optional<Tree> getTreeById(UUID id) {
        return treeRepository.findById(id);
    }

    @Override
    public List<Tree> getAllTrees() {
        return treeRepository.findAll();
    }

    @Override
    public Tree updateTree(UUID id, Tree tree) {
        return treeRepository.findById(id).map(existingTree -> {
            existingTree.setPlantingDate(tree.getPlantingDate());
            existingTree.setAge(tree.getAge());
            existingTree.setField(tree.getField());
            return treeRepository.save(existingTree);
        }).orElseThrow(() -> new RuntimeException("Tree not found"));
    }

    @Override
    public void deleteTree(UUID id) {
        treeRepository.deleteById(id);
    }
}
