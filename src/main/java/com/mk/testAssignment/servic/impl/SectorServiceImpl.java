package com.mk.testAssignment.servic.impl;

import com.mk.testAssignment.domain.Sector;
import com.mk.testAssignment.dto.SectorDTO;
import com.mk.testAssignment.repository.SectorRepository;
import com.mk.testAssignment.servic.SectorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SectorServiceImpl implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;


    @Override
    public List<SectorDTO> findAll() {
        List<Sector> result = sectorRepository.findAll();//findByParentIdSelectLevel();

        List<Sector> sectors = new ArrayList<>();

        for (Sector sector : result) {
            if (sector.getParentId() == 0){
                sectors.add(sector);
            }else if (sector.getParentId() != 0){
                sectors = getChildList(sectors, sector.getParentId(), result.size());

            }
        }

        List<SectorDTO> dtoList = new ArrayList<>();
        sectors.stream().forEach(sector -> {
            SectorDTO dto = new SectorDTO();
            BeanUtils.copyProperties(sector , dto);
            dtoList.add(dto);
        });
        return dtoList;
    }

    @Override
    public SectorDTO find(Integer id) {
        Sector sector = sectorRepository.getOne(id);
        SectorDTO dto = new SectorDTO();
        BeanUtils.copyProperties(sector,dto);
        return dto;
    }

    private List<Sector> getChildList(List<Sector> sectorList, Integer parentId, int sizeList){
        List<Sector> sectors = sectorRepository.findByParentId(parentId);
        if (sectorList != null && sectorList.size() > 0){
            for (Sector sector : sectors) {
                if(sectorList.stream().noneMatch(sector1 -> sector1.getId().equals(sector.getId())))
                    sectorList.add(sector);
                if (sectorList.size() != sizeList)
                    getChildList(sectorList, sector.getId(), sizeList);
            }
        }
        return sectorList;
    }

    @Override
    public void saveAll(List<SectorDTO> sectorDTOS) {

        List<Sector> sectors = new ArrayList<>();
        sectorDTOS.stream().forEach(sectorDTO -> {
            Sector sector = new Sector();
            BeanUtils.copyProperties(sectorDTO , sector);
            sectors.add(sector);
        });
        sectorRepository.saveAll(sectors);
    }

    @Override
    public Map<Integer, SectorDTO> getMapSectorDTOs(){

        Map<Integer, SectorDTO> map = new HashMap<>();
        List<SectorDTO> sectorDTOList = this.findAll();
        if (sectorDTOList != null){
            sectorDTOList.stream().forEach(sectorDTO -> {
                map.put(sectorDTO.getId(), sectorDTO);
            });
        }
        return map;
    }

}
