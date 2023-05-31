package com.weed.PM.repository;

import com.weed.PM.entity.Dust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DustRepository extends JpaRepository<Dust, Long> {
    default Dust findLastRow() {
        List<Dust> allDusts = findAll();
        if (!allDusts.isEmpty()) {
            return allDusts.get(allDusts.size() - 1);
        } else {
            return null;
        }
    }
}
