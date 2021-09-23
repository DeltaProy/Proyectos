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

import com.deltasac.api.entity.TipoSoft;
import com.deltasac.api.service.ITiposSoftService;

@RestController
@RequestMapping("/tipossoft")
public class TiposSoftController {

	@Autowired
	private ITiposSoftService serviceTiposSoft;
	
	@GetMapping("/listar")
	public List<TipoSoft> buscarTodos(){
		return serviceTiposSoft.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public TipoSoft guardar(@RequestBody TipoSoft tipoSoft) {
		serviceTiposSoft.guardar(tipoSoft);
		return tipoSoft;
	}
	
	@PutMapping("/actualizar")
	public TipoSoft modificar(@RequestBody TipoSoft tipoSoft) {
		serviceTiposSoft.guardar(tipoSoft);
		return tipoSoft;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int idtipoSoft) {
		serviceTiposSoft.eliminar(idtipoSoft);
		return "Registro Eliminado";
	}
}
