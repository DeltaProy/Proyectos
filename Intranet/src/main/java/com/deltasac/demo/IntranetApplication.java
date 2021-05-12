package com.deltasac.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntranetApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntranetApplication.class, args);
		
		//Testeando, al hacer push me pide varias veces las credenciales, hace el push pero no deja de pedirmelas test 3
	}

}
