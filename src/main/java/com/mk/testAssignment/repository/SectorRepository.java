package com.mk.testAssignment.repository;

import com.mk.testAssignment.domain.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Integer> {

    List<Sector> findByParentId(Integer parentId);

}
