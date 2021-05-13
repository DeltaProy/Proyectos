package com.deltasac.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deltasac.domain.Area;
import com.deltasac.servicio.AreaServiceImpl;

@SpringBootApplication
public class IntranetApplication implements CommandLineRunner {
	

	public static void main(String[] args) {
		SpringApplication.run(IntranetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");
		
		AreaServiceImpl areaService = new AreaServiceImpl();
		
		List<Area> areas = areaService.listarAreas();

	}

}
