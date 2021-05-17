package com.deltasac.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.deltasac.api.service.IUbigeosService;

@RestController
@RequestMapping("/ubigeos")
public class UbigeosController {

	@Autowired
	private IUbigeosService serviceUbigeos;
	
	@GetMapping("/departamentos")
	public List<String> buscardepartamentos(){
		return serviceUbigeos.buscarDepartamentos();
	}
	
	@GetMapping("/provincias/{departamento}")
	public List<String> buscarProvinciasPorDep(@PathVariable("departamento") String departamento){
		return serviceUbigeos.buscarProvinciasPorDep(departamento);
	}
	
	@GetMapping("/distritos/{departamento}/{provincia}")
	public List<String> buscardistritosPorDepProv(@PathVariable("departamento") String departamento, @PathVariable("provincia") String provincia){
		return serviceUbigeos.buscarDistritosPorDepProv(departamento, provincia);
	}
	
	@GetMapping("/codigo/{departamento}/{provincia}/{distrito}")
	public String buscarUbigeo(@PathVariable("departamento") String departamento, @PathVariable("provincia") String provincia, @PathVariable("distrito") String distrito){
		return serviceUbigeos.buscarUbigeo(departamento, provincia, distrito);
	}
	
}
