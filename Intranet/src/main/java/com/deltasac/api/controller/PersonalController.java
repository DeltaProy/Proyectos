package com.deltasac.api.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.deltasac.api.entity.CargoPK;
import com.deltasac.api.entity.Personal;
import com.deltasac.api.service.IAreaService;
import com.deltasac.api.service.ICargoService;
import com.deltasac.api.service.IDireccionesService;
import com.deltasac.api.service.IEmailsService;
import com.deltasac.api.service.IEmpresasService;
import com.deltasac.api.service.IGesSoftwaresService;
import com.deltasac.api.service.IPersonalService;
import com.deltasac.api.service.ITelefonosService;
import com.deltasac.api.service.ITiposDocsService;
import com.deltasac.api.service.jpa.FileStorageService;

@CrossOrigin("http://173.255.202.95:8080")
@RestController
@RequestMapping("/personal")
public class PersonalController {

	@Autowired
	private IPersonalService servicePersonal;
	@Autowired
	private ITiposDocsService serviceTipoDoc;
	@Autowired
	private IEmpresasService serviceEmpresa;
	@Autowired
	private IAreaService serviceArea;
	@Autowired
	private ICargoService serviceCargo;
	@Autowired
	private IDireccionesService serviceDireccion;
	@Autowired
	private IEmailsService serviceEmail;
	@Autowired
	private ITelefonosService serviceTelefono;
	@Autowired
	private IGesSoftwaresService serviceGesSoftware;
	@Autowired
	private FileStorageService fss;
	
	
	@GetMapping("/listar")
	public List<Personal> buscarTodos(){
		return servicePersonal.buscarTodos();
	}
	
	@GetMapping("/buscar/{id}")
	public Personal buscarPersonal(@PathVariable("id") int idpersonal){
		return servicePersonal.buscarPorId(idpersonal);
	}
	
	@GetMapping("/buscar/{nomper}/{apeper}")
	public Personal buscarPersonalPorNombre(@PathVariable("nomper") String nomper, @PathVariable("apeper") String apeper){
		return servicePersonal.buscarPorNombre(nomper, apeper);
	}
	
	@GetMapping("/listarArea/{idarea}")
	public List<Personal> buscarPorArea(@PathVariable("idarea") int idarea){
		return servicePersonal.buscarPorArea(idarea);
	}
	
	@PostMapping("/guardar")
	public Object guardar(@RequestBody Personal personal) {
		if(serviceTipoDoc.buscarPorId(personal.getIdtipodoc()) == null) {
			return "El idTipoDoc no existe en la base de datos";
		}
		if(serviceEmpresa.buscarPorId(personal.getIdempresa()) == null) {
			return "El idEmpresa no existe en la base de datos";
		}
		if(serviceArea.buscarId(personal.getIdarea()) == null) {
			return "El idArea no existe en la base de datos";
		}
		if(serviceCargo.buscarId(new CargoPK(personal.getIdcargo(), personal.getIdarea())) == null) {
			return "El idCargo no existe en la base de datos";
		}
		servicePersonal.guardar(personal);
		return personal;	
	}
	
	@PutMapping("/actualizar")
	public Object modificar(@RequestBody Personal personal) {
		if(serviceTipoDoc.buscarPorId(personal.getIdtipodoc()) == null) {
			return "El idTipoDoc no existe en la base de datos";
		}
		if(serviceEmpresa.buscarPorId(personal.getIdempresa()) == null) {
			return "El idEmpresa no existe en la base de datos";
		}
		if(serviceArea.buscarId(personal.getIdarea()) == null) {
			return "El idArea no existe en la base de datos";
		}
		if(serviceCargo.buscarId(new CargoPK(personal.getIdcargo(), personal.getIdarea())) == null) {
			return "El idCargo no existe en la base de datos";
		}
		servicePersonal.guardar(personal);
		return personal;					
	}
	
	@DeleteMapping("/eliminar/{idpersonal}")
	public String eliminar(@PathVariable("idpersonal") int idPersonal) {
		try {
			try {
				serviceGesSoftware.eliminarPorPersonal(idPersonal);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			servicePersonal.eliminar(idPersonal);
			
			try {
				serviceDireccion.eliminarPorPersonal(idPersonal);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				serviceEmail.eliminarPorPersonal(idPersonal);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				serviceTelefono.eliminarPorPersonal(idPersonal);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return "Registro Eliminado";			
		} catch (Exception e) {
			return "El registro con la llave proporcionada no existe o ya fue eliminado";
		}
	}
	
	@PostMapping("/subirfoto/{idpersonal}")
	public Object subirCertificado(@RequestParam("file") MultipartFile file, @PathVariable("idpersonal") int idPersonal) {
		Personal personal= servicePersonal.buscarPorId(idPersonal);
		
		if(personal == null) {
			return "Id proporcionado no valido, registro inexistente";
		}
		if(!(file.getOriginalFilename().endsWith(".jpg") || file.getOriginalFilename().endsWith(".jpeg"))) {
			return "Archivo invalido, solo se admite jpg o jpeg";
		}
		
		try {
			String fileName = fss.uploadFotoPersonal(file);
			
			personal.setFotografia(fileName);
			servicePersonal.guardar(personal);
			
			return personal;	
			
		} catch (Exception e) {
			return "Ocurrion un error al guardar certificado";
		}
		
	}
	
	@GetMapping("/getfoto/{idpersonal}")
	public ResponseEntity < Resource > obtenercertificado(@PathVariable("idpersonal") int idPersonal, HttpServletRequest request) throws IOException {
		Personal personal = servicePersonal.buscarPorId(idPersonal);
		
		if(personal == null) {
			return ResponseEntity.notFound().build();
		}
		try {
			Resource recurso = fss.getFotoPersonal(personal.getFotografia());			
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
