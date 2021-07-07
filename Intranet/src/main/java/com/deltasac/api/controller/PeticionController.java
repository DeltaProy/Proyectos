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
import com.deltasac.api.entity.Peticion;
import com.deltasac.api.service.IAreaService;
import com.deltasac.api.service.IPeticionDetService;
import com.deltasac.api.service.IPeticionService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/peticion")
public class PeticionController {

	@Autowired
	private IPeticionService servicePeticion;
	@Autowired
	private IPeticionDetService servicePeticionDet;
	@Autowired
	private IAreaService serviceArea;
	
	@GetMapping("/listar")
	public List<Peticion> buscarTodos(){
		return servicePeticion.buscarTodos();
	}
	
	@GetMapping("/listarArea/{idarea}")
	public List<Peticion> buscarPorArea(@PathVariable("idarea") Integer idArea){
		return servicePeticion.buscarbuscarPeticionPorArea(idArea);
	}
	
	@GetMapping("/listarPendientes/{idusuario}")
	public List<Peticion> buscarPendientePorIdUsuario(@PathVariable("idusuario") Integer idUsuario){
		Area area = serviceArea.buscarAreaPorIdresponsable(idUsuario);
		if(area != null) {
			return servicePeticion.buscarbuscarPeticionPorArea(area.getIdarea());
		}else {
			return null;
		}
		
	}
	
	@GetMapping("/listarAsignado/{idasignado}")
	public List<Peticion> buscarPorAsignado(@PathVariable("idasignado") Integer idAsignado){
		return servicePeticion.buscarbuscarPeticionPorAsignado(idAsignado);
	}
	
	@GetMapping("/listarUsuario/{idusuario}")
	public List<Peticion> buscarPorUsuario(@PathVariable("idusuario") Integer idUsuario){
		return servicePeticion.buscarbuscarPeticionPorUsuario(idUsuario);
	}
	
	@PostMapping("/guardar")
	public Peticion guardar(@RequestBody Peticion peticion) {
		servicePeticion.guardar(peticion);
		return peticion;
	}
	
	@PutMapping("/actualizar")
	public Peticion modificar(@RequestBody Peticion peticion) {
		servicePeticion.guardar(peticion);
		return peticion;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer idPeticion) {
		servicePeticion.eliminar(idPeticion);
		return "Registro Eliminado";	
	}
}
