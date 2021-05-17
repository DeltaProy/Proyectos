package com.deltasac.api.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deltasac.api.entity.Telefono;
import com.deltasac.api.entity.TelefonoPK;
import com.deltasac.api.service.ITelefonosService;

@RestController
@RequestMapping("/telefonos")
public class TelefonosController {

	@Autowired
	private ITelefonosService serviceTelefono;
	
	@GetMapping("/listar")
	public List<Telefono> buscarTodos(){
		return serviceTelefono.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Telefono guardar(@RequestBody Telefono telefono) {
		if(validarDiscado(telefono.getDiscado())) {
			serviceTelefono.guardar(telefono);
			return telefono;			
		}else {
			return null;
		}
	}
	
	@PutMapping("/actualizar")
	public Telefono modificar(@RequestBody Telefono telefono) {
		if(validarDiscado(telefono.getDiscado())) {
			serviceTelefono.guardar(telefono);
			return telefono;			
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar/{idpersonal}/{nrotelf}")
	public String eliminar(@PathVariable("idpersonal") int idPersonal, @PathVariable("nrotelf") int nroTelf) {
		serviceTelefono.eliminar(new TelefonoPK(idPersonal, nroTelf));
		return "Registro Eliminado";
	}
	
	private boolean validarDiscado(String discado) {
		Pattern pat= Pattern.compile("^((\\d)|(-)|(\\))|(\\())+$");
		Matcher mat = pat.matcher(discado);
		return mat.find();
	}
	
}
