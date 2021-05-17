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

import com.deltasac.api.entity.TipoTelf;
import com.deltasac.api.service.ITiposTelfsService;

@RestController
@RequestMapping("/tipostelfs")
public class TiposTelfsController {

	@Autowired
	private ITiposTelfsService serviceTiposTelfs;
	
	@GetMapping("/listar")
	public List<TipoTelf> buscarTodos(){
		return serviceTiposTelfs.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public TipoTelf guardar(@RequestBody TipoTelf tipotelf) {
		serviceTiposTelfs.guardar(tipotelf);
		return tipotelf;
	}
	
	@PutMapping("/actualizar")
	public TipoTelf modificar(@RequestBody TipoTelf tipotelf) {
		serviceTiposTelfs.guardar(tipotelf);
		return tipotelf;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int idTipoTelf) {
		serviceTiposTelfs.eliminar(idTipoTelf);
		return "Registro Eliminado";
	}
}
