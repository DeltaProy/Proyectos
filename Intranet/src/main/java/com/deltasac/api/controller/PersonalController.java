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
	
	
	@GetMapping("/listar")
	public List<Personal> buscarTodos(){
		return servicePersonal.buscarTodos();
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
		if(!validarNombreArchivo(personal.getFotografia())) {
			return "El nombre de archivo del certificado es invalido";
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
		if(!validarNombreArchivo(personal.getFotografia())) {
			return "El nombre de archivo del certificado es invalido";
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
	
	private boolean validarNombreArchivo(String nombreArchivo) {
		Pattern pat= Pattern.compile("^.*(\\.(jpg|jpeg))$");
		Matcher mat = pat.matcher(nombreArchivo);
		return mat.find();
	}
	
}
