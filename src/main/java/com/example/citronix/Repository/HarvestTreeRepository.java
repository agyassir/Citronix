package com.example.citronix.Repository;

import com.example.citronix.Entity.Enums.Season;
import com.example.citronix.Entity.HarvestTree;
import com.example.citronix.Entity.Tree;
import com.example.citronix.Repository.Criteria.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface HarvestTreeRepository extends JpaRepository<HarvestTree, UUID>, CustomRepository<HarvestTree> {
    @Query("SELECT COUNT(hd) > 0 FROM HarvestTree hd " +
            "WHERE hd.tree = :tree AND hd.harvest.season = :season AND YEAR(hd.harvest.dateOfHarvest) = :year")
    boolean existsByTreeAndHarvestSeasonAndYear(
            @Param("tree") Tree tree, @Param("season") Season season, @Param("year") int year);
}
