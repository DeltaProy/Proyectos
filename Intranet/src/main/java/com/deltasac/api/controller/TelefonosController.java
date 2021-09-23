package com.deltasac.api.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import com.deltasac.api.entity.Telefono;
import com.deltasac.api.entity.TelefonoPK;
import com.deltasac.api.service.ITelefonosService;
import com.deltasac.api.service.ITiposTelfsService;

@RestController
@RequestMapping("/telefonos")
public class TelefonosController {

	@Autowired
	private ITelefonosService serviceTelefono;
	@Autowired
	private ITiposTelfsService serviceTipoTelf;
	
	@GetMapping("/listar")
	public List<Telefono> buscarTodos(){
		return serviceTelefono.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Object guardar(@RequestBody Telefono telefono) {
		if(serviceTipoTelf.buscarPorId(telefono.getIdtipotelf()) != null) {
			if(validarDiscado(telefono.getDiscado())) {
				serviceTelefono.guardar(telefono);
				return telefono;
			}else {
				return "Discado invalido, debe contener solo numeros, guiones y/o parentesis";
			}			
		}else {
			return "El idTipoTelf no existe en la base de datos";
		}
	}
	
	@PutMapping("/actualizar")
	public Object modificar(@RequestBody Telefono telefono) {
		if(serviceTipoTelf.buscarPorId(telefono.getIdtipotelf()) != null) {
			if(validarDiscado(telefono.getDiscado())) {
				serviceTelefono.guardar(telefono);
				return telefono;
			}else {
				return "Discado invalido, debe contener solo numeros, guiones y/o parentesis";
			}			
		}else {
			return "El idTipoTelf no existe en la base de datos";
		}
	}
	
	@DeleteMapping("/eliminar/{idpersonal}/{nrotelf}")
	public String eliminar(@PathVariable("idpersonal") int idPersonal, @PathVariable("nrotelf") int nroTelf) {
		try {
			serviceTelefono.eliminar(new TelefonoPK(idPersonal, nroTelf));
			return "Registro Eliminado";			
		} catch (Exception e) {
			return "El registro con la llave primaria proporcionada no existe o ya fue eliminado";
		}
	}
	
	private boolean validarDiscado(String discado) {
		Pattern pat= Pattern.compile("^((\\d)|(-)|(\\))|(\\())+$");
		Matcher mat = pat.matcher(discado);
		return mat.find();
	}
	
}
