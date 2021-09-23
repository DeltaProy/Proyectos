package com.deltasac.api.controller;

import java.util.List;

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

import com.deltasac.api.entity.TipoDirec;
import com.deltasac.api.service.ITiposDirecService;

@RestController
@RequestMapping("/tiposdirec")
public class TiposDirecController {

	@Autowired
	private ITiposDirecService serviceTiposDirec;
	
	@GetMapping("/listar")
	public List<TipoDirec> buscarTodos(){
		return serviceTiposDirec.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public TipoDirec guardar(@RequestBody TipoDirec tipoDirec) {
		serviceTiposDirec.guardar(tipoDirec);
		return tipoDirec;
	}
	
	@PutMapping("/actualizar")
	public TipoDirec modificar(@RequestBody TipoDirec tipoDirec) {
		serviceTiposDirec.guardar(tipoDirec);
		return tipoDirec;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int idtipoDirec) {
		serviceTiposDirec.eliminar(idtipoDirec);
		return "Registro Eliminado";
	}
}
