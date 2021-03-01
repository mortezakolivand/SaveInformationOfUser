package com.mk.testAssignment.servic;

import com.mk.testAssignment.dto.SectorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface SectorService {

    List<SectorDTO> findAll();
    SectorDTO find(Integer id);
    void saveAll(List<SectorDTO> sectorDTOS);
    Map<Integer, SectorDTO> getMapSectorDTOs();
}
