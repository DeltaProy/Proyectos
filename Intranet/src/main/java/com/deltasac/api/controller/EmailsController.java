package com.deltasac.api.controller;

import java.util.List;
import java.util.regex.*;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/emails")
public class EmailsController {

	@Autowired
	private IEmailsService serviceEmail;
	
	@GetMapping("/listar")
	public List<Email> buscarTodos(){
		return serviceEmail.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Email guardar(@RequestBody Email email) {
		if(validarEmail(email.getDiremail())) {
			serviceEmail.guardar(email);
			return email;			
		}else {
			return null;
		}
	}
	
	@PutMapping("/actualizar")
	public Email modificar(@RequestBody Email email) {		
		if(validarEmail(email.getDiremail())) {
			serviceEmail.guardar(email);
			return email;
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar/{idpersonal}/{nroemail}")
	public String eliminar(@PathVariable("idpersonal") int idPersonal, @PathVariable("nroemail") int nroEmail) {
		serviceEmail.eliminar(new EmailPK(idPersonal, nroEmail));
		return "Registro Eliminado";
	}
	
	private boolean validarEmail(String email) {
		Pattern pat= Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mat = pat.matcher(email);
		return mat.find();
	}
	
}
