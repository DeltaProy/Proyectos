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

import com.deltasac.api.entity.Empresa;
import com.deltasac.api.service.IEmpresasService;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

	@Autowired
	private IEmpresasService serviceEmpresas;
	
	@GetMapping("/listar")
	public List<Empresa> buscarTodos(){
		return serviceEmpresas.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Empresa guardar(@RequestBody Empresa empresa) {
		serviceEmpresas.guardar(empresa);
		return empresa;
	}
	
	@PutMapping("/actualizar")
	public Empresa modificar(@RequestBody Empresa empresa) {
		serviceEmpresas.guardar(empresa);
		return empresa;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int idEmpresa) {
		serviceEmpresas.eliminar(idEmpresa);
		return "Registro Eliminado";
	}
}
