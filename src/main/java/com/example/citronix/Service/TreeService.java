package com.example.citronix.Service;

import com.example.citronix.Entity.Tree;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TreeService {
    Tree createTree(Tree tree);

    Optional<Tree> getTreeById(UUID id);

    List<Tree> getAllTrees();

    Tree updateTree(UUID id, Tree tree);

    void deleteTree(UUID id);
}
