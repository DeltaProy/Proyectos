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

import com.deltasac.api.entity.Software;
import com.deltasac.api.service.ISoftwaresService;
import com.deltasac.api.service.ITiposSoftService;

@RestController
@RequestMapping("/softwares")
public class SoftwaresController {

	@Autowired
	private ISoftwaresService serviceSoftware;
	@Autowired
	private ITiposSoftService serviceTiposSoft;
	
	@GetMapping("/listar")
	public List<Software> buscarTodos(){
		return serviceSoftware.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Object guardar(@RequestBody Software software) {
		if(serviceTiposSoft.buscarPorId(software.getIdtiposoft()) == null) {
			return "El id tipoSoft no existe en la base de datos";
		}
		serviceSoftware.guardar(software);
		return software;
	}
	
	@PutMapping("/actualizar")
	public Object modificar(@RequestBody Software software) {
		if(serviceTiposSoft.buscarPorId(software.getIdtiposoft()) == null) {
			return "El id idTipoSoft no existe en la base de datos";
		}
		serviceSoftware.guardar(software);
		return software;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int idSoftware) {
		serviceSoftware.eliminar(idSoftware);
		return "Registro Eliminado";
	}
}
