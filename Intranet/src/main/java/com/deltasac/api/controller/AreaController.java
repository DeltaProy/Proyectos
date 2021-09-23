package com.deltasac.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deltasac.api.entity.Area;
import com.deltasac.api.service.IAreaService;

@RestController
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private IAreaService serviceArea;
	
	@GetMapping("/listar")
	public List<Area> buscarTodos(){
		return serviceArea.buscarTodos();
	}
	
	@GetMapping("/listarArea/{id}")
	public Area buscarArea(@PathVariable("id") int idarea){
		return serviceArea.buscarId(idarea);
	}
	
	@GetMapping("/listarAreaxResponsable/{idresponsable}")
	public Area buscarAreaPorIdresponsable(@PathVariable("idresponsable") int idresponsable){
		return serviceArea.buscarAreaPorIdresponsable(idresponsable);
	}
	
	@PostMapping("/guardar")
	public Area guardar(@RequestBody Area area) {
		serviceArea.guardar(area);
		return area;
	}
	
	@PutMapping("/actualizar")
	public Area modificar(@RequestBody Area area) {
		serviceArea.guardar(area);
		return area;
	}
	
	@DeleteMapping(value = {"/eliminar/{id}", "/eliminar/{id}/{recursivo}"})
	public String eliminar(@PathVariable("id") int idArea, @PathVariable("recursivo") Optional<String> isRecursivo) {
		if(isRecursivo.isPresent() || serviceArea.buscarId(idArea).getCargos().isEmpty()) {
			serviceArea.eliminar(idArea);
			return "Registro Eliminado";
		}else {
			return "El registro tiene Cargos asociados";
		}
		
	}
}
