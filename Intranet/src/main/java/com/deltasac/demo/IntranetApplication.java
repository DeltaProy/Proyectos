package com.deltasac.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntranetApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(IntranetApplication.class, args);
	}


	/*@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");
		
		AreaServiceImpl areaService = new AreaServiceImpl();
		
		List<Area> areas = areaService.listarAreas();

	}*/

}
