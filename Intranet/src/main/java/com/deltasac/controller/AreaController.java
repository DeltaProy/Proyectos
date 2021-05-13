package com.deltasac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deltasac.domain.Area;
import com.deltasac.servicio.AreaService;

@RestController
@RequestMapping("/api")
public class AreaController {
	@Autowired
	private AreaService serviceAreas;
	
	@GetMapping("/areas")
	public List<Area> listarAreas(){
		return serviceAreas.listarAreas();
	}
}
