package com.deltasac.api.controller;

import java.util.List;
import java.util.regex.*;

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

import com.deltasac.api.entity.Email;
import com.deltasac.api.entity.EmailPK;
import com.deltasac.api.service.IEmailsService;
import com.deltasac.api.service.ITiposEmailsService;

@RestController
@RequestMapping("/emails")
public class EmailsController {

	@Autowired
	private IEmailsService serviceEmail;
	@Autowired
	private ITiposEmailsService serviceTipoEmail;
	
	@GetMapping("/listar")
	public List<Email> buscarTodos(){
		return serviceEmail.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Object guardar(@RequestBody Email email) {
		if(serviceTipoEmail.buscarPorId(email.getIdtipoemail()) != null) {
			if(validarEmail(email.getDiremail())) {
				serviceEmail.guardar(email);
				return email;			
			}else {
				return "El email ingresado no es valido";
			}			
		}else {
			return "El idTipoEmail proporcionado no existe en la base de datos";
		}
	}
	
	@PutMapping("/actualizar")
	public Object modificar(@RequestBody Email email) {		
		if(serviceTipoEmail.buscarPorId(email.getIdtipoemail()) != null) {
			if(validarEmail(email.getDiremail())) {
				serviceEmail.guardar(email);
				return email;			
			}else {
				return "El email ingresado no es valido";
			}			
		}else {
			return "El idTipoEmail proporcionado no existe en la base de datos";
		}
	}
	
	@DeleteMapping("/eliminar/{idpersonal}/{nroemail}")
	public String eliminar(@PathVariable("idpersonal") int idPersonal, @PathVariable("nroemail") int nroEmail) {
		try {
			serviceEmail.eliminar(new EmailPK(idPersonal, nroEmail));
			return "Registro Eliminado";			
		} catch (Exception e) {
			return "El registro con la llave primaria proporcionada no existe o ya fue eliminado";
		}
	}
	
	private boolean validarEmail(String email) {
		Pattern pat= Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mat = pat.matcher(email);
		return mat.find();
	}
	
}
