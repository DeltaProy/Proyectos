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

import com.deltasac.api.entity.Direccion;
import com.deltasac.api.entity.DireccionPK;
import com.deltasac.api.service.IDireccionesService;
import com.deltasac.api.service.ITiposDirecService;
import com.deltasac.api.service.IUbigeosService;

@CrossOrigin(origins = {"http://173.255.202.95:8080", "http://localhost:4200"})
@RestController
@RequestMapping("/direcciones")
public class DireccionesController {

	@Autowired
	private IDireccionesService serviceDireccion;
	@Autowired
	private IUbigeosService serviceUbigeo;
	@Autowired
	private ITiposDirecService serviceTipoDirec;
	
	@GetMapping("/listar")
	public List<Direccion> buscarTodos(){
		return serviceDireccion.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Object guardar(@RequestBody Direccion direccion) {
		if(serviceTipoDirec.buscarPorId(direccion.getIdtipodir()) != null) {
			if(serviceUbigeo.buscarPorId(direccion.getIdubigeo()) != null) {
				serviceDireccion.guardar(direccion);
				return direccion;				
			}else {
				return "El idUbigeo no existe en la base de datos";
			}
		}else {
			return "El idTipoDir no existe en la base de datos";
		}
	}
	
	@PutMapping("/actualizar")
	public Object modificar(@RequestBody Direccion direccion) {
		if(serviceTipoDirec.buscarPorId(direccion.getIdtipodir()) != null) {
			if(serviceUbigeo.buscarPorId(direccion.getIdubigeo()) != null) {
				serviceDireccion.guardar(direccion);
				return direccion;				
			}else {
				return "El idUbigeo no existe en la base de datos";
			}
		}else {
			return "El idTipoDir no existe en la base de datos";
		}
	}
	
	@DeleteMapping("/eliminar/{idpersonal}/{nrodir}")
	public String eliminar(@PathVariable("idpersonal") int idPersonal, @PathVariable("nrodir") int nroDir) {
		try {
			serviceDireccion.eliminar(new DireccionPK(idPersonal, nroDir));
			return "Registro Eliminado";			
		} catch (Exception e) {
			return "El registro con la llave proporcionada no existe o ya fue eliminado";
		}
	}
	
}
