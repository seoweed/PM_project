package com.weed.PM.repository;

import com.weed.PM.entity.Dust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DustRepository extends JpaRepository<Dust, Long> {

}
