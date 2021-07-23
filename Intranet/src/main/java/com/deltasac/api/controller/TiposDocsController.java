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

import com.deltasac.api.entity.TipoDoc;
import com.deltasac.api.service.ITiposDocsService;

@CrossOrigin("http://173.255.202.95:8080")
@RestController
@RequestMapping("/tiposdocs")
public class TiposDocsController {

	@Autowired
	private ITiposDocsService serviceTiposDocs;
	
	@GetMapping("/listar")
	public List<TipoDoc> buscarTodos(){
		return serviceTiposDocs.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public TipoDoc guardar(@RequestBody TipoDoc tipodoc) {
		serviceTiposDocs.guardar(tipodoc);
		return tipodoc;
	}
	
	@PutMapping("/actualizar")
	public TipoDoc modificar(@RequestBody TipoDoc tipodoc) {
		serviceTiposDocs.guardar(tipodoc);
		return tipodoc;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public Object eliminar(@PathVariable("id") int idTipoDoc) {
		serviceTiposDocs.eliminar(idTipoDoc);
		return "Registro Eliminado";
	}
}
