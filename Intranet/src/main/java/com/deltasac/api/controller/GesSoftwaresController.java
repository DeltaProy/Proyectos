package com.deltasac.api.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deltasac.api.entity.GesSoftware;
import com.deltasac.api.entity.GesSoftwarePK;
import com.deltasac.api.service.IGesSoftwaresService;
import com.deltasac.api.service.ISoftwaresService;
import com.deltasac.api.service.jpa.FileStorageService;

@RestController
@RequestMapping("/gessoftwares")
public class GesSoftwaresController {

	@Autowired
	private IGesSoftwaresService serviceGesSoftware;
	@Autowired
	private ISoftwaresService serviceSoftware;
	@Autowired
	private FileStorageService fss;
	
	
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
	
	@PostMapping("/subircertificado/{idpersonal}/{idsoft}")
	public Object subirCertificado(@RequestParam("file") MultipartFile file, @PathVariable("idpersonal") int idPersonal, @PathVariable("idsoft") int idSoft) {
		GesSoftware gesSoftware = serviceGesSoftware.buscarPorId(new GesSoftwarePK(idPersonal, idSoft));
		
		if(gesSoftware == null) {
			return "Id proporcionado no valido, registro inexistente";
		}
		if(!(file.getOriginalFilename().endsWith(".jpg") || file.getOriginalFilename().endsWith(".jpeg"))) {
			return "Archivo invalido, solo se admite jpg o jpeg";
		}
		
		try {
			String fileName = fss.uploadCertificado(file);
			
			gesSoftware.setCertificado(fileName);
			serviceGesSoftware.guardar(gesSoftware);
			
			return gesSoftware;	
			
		} catch (Exception e) {
			return "Ocurrion un error al guardar certificado";
		}
		
	}
	
	@GetMapping("/getcertificado/{idpersonal}/{idsoft}")
	public ResponseEntity < Resource > obtenercertificado(@PathVariable("idpersonal") int idPersonal, @PathVariable("idsoft") int idSoft, HttpServletRequest request) throws IOException {
		GesSoftware gesSoftware = serviceGesSoftware.buscarPorId(new GesSoftwarePK(idPersonal, idSoft));
		
		if(gesSoftware == null) {
			return ResponseEntity.notFound().build();
		}
		try {
			Resource recurso = fss.getCertificado(gesSoftware.getCertificado());			
			String contentType = null;
			try {
				contentType = request.getServletContext().getMimeType(recurso.getFile().getAbsolutePath());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (contentType == null) {
				contentType = "application/octet-stream";
			}
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(contentType))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
					.body(recurso);
		} catch (Exception e) {
			
			return ResponseEntity.notFound().build();
		}
	}
}
