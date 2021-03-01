package com.mk.testAssignment;

import com.mk.testAssignment.dto.SectorDTO;
import com.mk.testAssignment.repository.SectorRepository;
import com.mk.testAssignment.servic.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@ComponentScan("com.mk.testAssignment")
@SpringBootApplication
public class TestAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAssignmentApplication.class, args);
	}

	@Component
	class DemoCommandLineRunner implements CommandLineRunner {

		@Autowired
		private SectorService sectorService;

		@Override
		public void run(String... args) throws Exception {

			List<SectorDTO> dtoList = new ArrayList<>();
			SectorDTO dto1 = new SectorDTO(1,"Manufacturing" ,0 , (byte) 0);
			dtoList.add(dto1);
			SectorDTO dto2 = new SectorDTO(19,"Construction materials" ,1 ,(byte) 1);
			dtoList.add(dto2);
			SectorDTO dto3 = new SectorDTO(18,"Electronics and Optics" ,1 , (byte) 1);
			dtoList.add(dto3);
			SectorDTO dto4 = new SectorDTO(6,"Food and Beverage" ,1 , (byte)1);
			dtoList.add(dto4);
			SectorDTO dto5 = new SectorDTO(342,"Bakery  confectionery products" ,6 , (byte) 2);
			dtoList.add(dto5);
			SectorDTO dto6 = new SectorDTO(43,"Beverages" ,6 , (byte) 2);
			dtoList.add(dto6);
			SectorDTO dto7 = new SectorDTO(42,"Fish  fish products" ,6 , (byte) 2);
			dtoList.add(dto7);
			SectorDTO dto8 = new SectorDTO(40,"Meat  meat products" ,6 , (byte) 2);
			dtoList.add(dto8);
			SectorDTO dto9 = new SectorDTO(39,"Milk  dairy products" ,6 , (byte) 2);
			dtoList.add(dto9);
			SectorDTO dto10 = new SectorDTO(437,"Other" ,6 , (byte) 2);
			dtoList.add(dto10);
			SectorDTO dto11 = new SectorDTO(378,"Sweets  snack food" ,6 , (byte) 2);
			dtoList.add(dto11);
			SectorDTO dto12 = new SectorDTO(13,"Furniture" ,1 , (byte) 1);
			dtoList.add(dto12);
			SectorDTO dto13 = new SectorDTO(389,"Bathroom/sauna" ,13 , (byte) 2);
			dtoList.add(dto13);
			SectorDTO dto14 = new SectorDTO(385,"Bedroom" ,13 , (byte) 2);
			dtoList.add(dto14);
			SectorDTO dto15 = new SectorDTO(390,"Children’s room" ,13 , (byte) 2);
			dtoList.add(dto15);
			SectorDTO dto16 = new SectorDTO(98,"Kitchen" ,13 , (byte) 2);
			dtoList.add(dto16);
			SectorDTO dto17 = new SectorDTO(101,"Living room" ,13 , (byte) 2);
			dtoList.add(dto17);
			SectorDTO dto18 = new SectorDTO(392,"Office" ,13 , (byte) 2);
			dtoList.add(dto18);
			SectorDTO dto19 = new SectorDTO(394,"Other (Furniture)" ,13 , (byte) 2);
			dtoList.add(dto19);
			SectorDTO dto20 = new SectorDTO(341,"Outdoor" ,13 , (byte) 2);
			dtoList.add(dto20);
			SectorDTO dto21 = new SectorDTO(99,"Project furniture" ,13 , (byte) 2);
			dtoList.add(dto21);

			sectorService.saveAll(dtoList);
		}
	}

}
