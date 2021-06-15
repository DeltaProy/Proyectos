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

import com.deltasac.api.entity.TipoEmail;
import com.deltasac.api.service.ITiposEmailsService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/tiposemails")
public class TiposEmailsController {

	@Autowired
	private ITiposEmailsService serviceTiposEmails;
	
	@GetMapping("/listar")
	public List<TipoEmail> buscarTodos(){
		return serviceTiposEmails.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public TipoEmail guardar(@RequestBody TipoEmail tipoemail) {
		serviceTiposEmails.guardar(tipoemail);
		return tipoemail;
	}
	
	@PutMapping("/actualizar")
	public TipoEmail modificar(@RequestBody TipoEmail tipoemail) {
		serviceTiposEmails.guardar(tipoemail);
		return tipoemail;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int idTipoEmail) {
		serviceTiposEmails.eliminar(idTipoEmail);
		return "Registro Eliminado";
	}
}
