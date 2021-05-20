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

import com.deltasac.api.entity.GesSoftware;
import com.deltasac.api.entity.GesSoftwarePK;
import com.deltasac.api.service.IGesSoftwaresService;
import com.deltasac.api.service.ISoftwaresService;

@RestController
@RequestMapping("/gessoftwares")
public class GesSoftwaresController {

	@Autowired
	private IGesSoftwaresService serviceGesSoftware;
	@Autowired
	private ISoftwaresService serviceSoftware;
	
	
	@GetMapping("/listar")
	public List<GesSoftware> buscarTodos(){
		return serviceGesSoftware.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Object guardar(@RequestBody GesSoftware gesSoftware) {
		try {
			if(gesSoftware.getNivel() < 1 || gesSoftware.getNivel() > 5) {
				return "El nivel debe estar en el rango de 1 a 5";
			}
			if(serviceSoftware.buscarPorId(gesSoftware.getIdsoft()) == null) {
				return "El idSoft no existe en la base de datos";
			}
			if(!validarNombreArchivo(gesSoftware.getCertificado())) {
				return "El nombre de archivo del certificado es invalido";
			}
			serviceGesSoftware.guardar(gesSoftware);
			return gesSoftware;				
		} catch (Exception e) {
			return "El idPersonal no existe en la base de datos";
		}
	}
	
	@PutMapping("/actualizar")
	public Object modificar(@RequestBody GesSoftware gesSoftware) {
		try {
			if(gesSoftware.getNivel() < 1 || gesSoftware.getNivel() > 5) {
				return "El nivel debe estar en el rango de 1 a 5";
			}
			if(serviceSoftware.buscarPorId(gesSoftware.getIdsoft()) == null) {
				return "El idSoft no existe en la base de datos";
			}
			if(!validarNombreArchivo(gesSoftware.getCertificado())) {
				return "El nombre de archivo del certificado es invalido";
			}
			serviceGesSoftware.guardar(gesSoftware);
			return gesSoftware;				
		} catch (Exception e) {
			return "El idPersonal no existe en la base de datos";
		}
	}
	
	@DeleteMapping("/eliminar/{idpersonal}/{idsoft}")
	public String eliminar(@PathVariable("idpersonal") int idPersonal, @PathVariable("idsoft") int idSoft) {
		try {
			serviceGesSoftware.eliminar(new GesSoftwarePK(idPersonal, idSoft));
			return "Registro Eliminado";			
		} catch (Exception e) {
			return "El registro con la llave proporcionada no existe o ya fue eliminado";
		}
	}
	
	private boolean validarNombreArchivo(String nombreArchivo) {
		Pattern pat= Pattern.compile("^.*(\\.(jpg|jpeg))$");
		Matcher mat = pat.matcher(nombreArchivo);
		return mat.find();
	}
}
