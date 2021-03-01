package com.mk.testAssignment;

import com.mk.testAssignment.dto.SectorDTO;
import com.mk.testAssignment.repository.SectorRepository;
import com.mk.testAssignment.servic.impl.SectorServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class TestAssignmentApplicationTests {

	@InjectMocks
	SectorServiceImpl sectorService;

	@Mock
	SectorRepository sectorRepository;

	@Test
	public void contextLoads() {

	}

	@Test
	public void saveAllSector()
	{
		List<SectorDTO> dtoList = new ArrayList<>();
		SectorDTO dto1 = new SectorDTO(1,"Manufacturing" ,0 , (byte) 0);
		dtoList.add(dto1);
		SectorDTO dto2 = new SectorDTO(19,"Construction materials" ,1 ,(byte) 1);
		dtoList.add(dto2);
		sectorService.saveAll(dtoList);
	}

}
