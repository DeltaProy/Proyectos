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

import com.deltasac.api.entity.Direccion;
import com.deltasac.api.entity.DireccionPK;
import com.deltasac.api.service.IDireccionesService;

@RestController
@RequestMapping("/direcciones")
public class DireccionesController {

	@Autowired
	private IDireccionesService serviceDireccion;
	
	@GetMapping("/listar")
	public List<Direccion> buscarTodos(){
		return serviceDireccion.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Direccion guardar(@RequestBody Direccion direccion) {
		serviceDireccion.guardar(direccion);
		return direccion;
	}
	
	@PutMapping("/actualizar")
	public Direccion modificar(@RequestBody Direccion direccion) {
		serviceDireccion.guardar(direccion);
		return direccion;
	}
	
	@DeleteMapping("/eliminar/{idpersonal}/{nrodir}")
	public String eliminar(@PathVariable("idpersonal") int idPersonal, @PathVariable("nrodir") int nroDir) {
		serviceDireccion.eliminar(new DireccionPK(idPersonal, nroDir));
		return "Registro Eliminado";
	}
	
}
