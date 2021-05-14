package com.deltasac.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deltasac.api.entity.Cargo;
import com.deltasac.api.entity.CargoPK;
import com.deltasac.api.service.ICargoService;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	@Autowired
	private ICargoService serviceCargo;
	
	@GetMapping("/listar")
	public List<Cargo> buscarTodos(){
		return serviceCargo.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Cargo guardar(@RequestBody Cargo cargo) {
		serviceCargo.guardar(cargo);
		return cargo;
	}
	
	@PutMapping("/actualizar")
	public Cargo modificar(@RequestBody Cargo cargo) {
		serviceCargo.guardar(cargo);
		return cargo;
	}
	
	@DeleteMapping("/eliminar/{idcargo}/{idarea}")
	public String eliminar(@PathVariable("idcargo") int idCargo, @PathVariable("idarea") int idArea) {
		serviceCargo.eliminar(new CargoPK(idCargo, idArea));
		return "Registro Eliminado";
	}
	
}
