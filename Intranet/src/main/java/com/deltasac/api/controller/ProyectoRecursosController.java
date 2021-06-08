package com.deltasac.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deltasac.api.entity.ProyectoRecurso;
import com.deltasac.api.entity.ProyectoRecursoPK;
import com.deltasac.api.service.IProyectoRecursosService;
import com.deltasac.api.service.IProyectosService;

@RestController
@RequestMapping("/proyectoRecursos")
public class ProyectoRecursosController {

	@Autowired
	private IProyectoRecursosService serviceProyectoRecurso;
	@Autowired
	private IProyectosService serviceProyecto;
	
	
	@GetMapping("/listar")
	public List<ProyectoRecurso> buscarTodos(){
		return serviceProyectoRecurso.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Object guardar(@RequestBody ProyectoRecurso proyectoRecurso) {
		if(serviceProyecto.buscarPorId(proyectoRecurso.getIdproyecto()) == null) {
			return "El idProyecto no existe en la base de datos";
		}
		serviceProyectoRecurso.guardar(proyectoRecurso);
		return proyectoRecurso;
	}
	
	@PutMapping("/actualizar")
	public Object actualizar(@RequestBody ProyectoRecurso proyectoRecurso) {
		if(serviceProyectoRecurso.buscarPorId(new ProyectoRecursoPK(proyectoRecurso.getIdproyecto(), proyectoRecurso.getIdpersonal())) == null) {
			return "El Recurso no existe en la base de datos";
		}
		serviceProyectoRecurso.guardar(proyectoRecurso);
		return proyectoRecurso;
	}
	
	@DeleteMapping("/eliminar")
	public String eliminar(@RequestParam("idproyecto") Integer idproyecto, @RequestParam("idpersonal") Integer idpersonal) {
		serviceProyectoRecurso.eliminar(new ProyectoRecursoPK(idproyecto, idpersonal));
		return "Registro eliminado";
	}
	
}
