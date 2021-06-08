package com.deltasac.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deltasac.api.entity.ProyectoHomologado;
import com.deltasac.api.entity.ProyectoHomologadoPK;
import com.deltasac.api.service.IProyectoHomologadosService;

import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;

@RestController
@RequestMapping("/proyectoHomologados")
public class ProyectoHomologadosController {

	@Autowired
	private IProyectoHomologadosService serviceProyectoHonologados;
	
	
	@GetMapping("/listar")
	public List<ProyectoHomologado> buscarTodos(){
		return serviceProyectoHonologados.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Object guardarHomolog(@RequestParam("file") MultipartFile file, @RequestParam("idproyecto") Integer idProyecto) {
		List<ProyectoHomologado> recursosNulos = new ArrayList<>();
		List<String> nombres = new ArrayList<>();
		//CREAR USUARIOS ges proy homolog
		try {
			MPPReader mppRead = new MPPReader();
			ProjectFile pf = mppRead.read(file.getInputStream());
			
			//CREAR USUARIOS ges proy homolog
			for(Task task: pf.getTasks()) {
				String nombre = "";
				try {
					nombre = task.getResourceAssignments().get(0).getResource().getName();//Cuando el recurso en el archivo esta vacio se demorara en responder ya que pasara por todos los errors							
				} catch (Exception e) {
				}
				ProyectoHomologado ph = serviceProyectoHonologados.buscarPorId(new ProyectoHomologadoPK(idProyecto, nombre));
				if(ph == null) {
					ph = new ProyectoHomologado();
					ph.setIdproyecto(idProyecto);
					ph.setNomcorto(nombre);
					serviceProyectoHonologados.guardar(ph);
					if(!nombres.contains(ph.getNomcorto())) {
						recursosNulos.add(ph);
						nombres.add(ph.getNomcorto());
					}
				} else {
					if(ph.getIdpersonal() == null) {
						if(!nombres.contains(ph.getNomcorto())) {
							recursosNulos.add(ph);
							nombres.add(ph.getNomcorto());
						}
					}
				}
			}
			
		} catch (MPXJException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recursosNulos;//Aca el frontend recive una lista de recursos con idpersonal nulo para que pida con un formulario validar esos recursos, si la lista es vacia no hay que hacer nada.
	}
	
	@PostMapping("/actualizar")
	public Object actualizar(@RequestBody() ProyectoHomologado ph) {
		try {
			serviceProyectoHonologados.guardar(ph);
		}catch (Exception e) {
			return "Error al actualizar el registro, revise si existe el id personal en la base de datos";
		}
		return ph;
	}

	@DeleteMapping("/eliminar")
	public String eliminar(@RequestParam("idproyecto") Integer idproyecto, @RequestParam("nomcorto") String nomCorto) {
		serviceProyectoHonologados.eliminar(new ProyectoHomologadoPK(idproyecto, nomCorto));
		return "Registro eliminado";
	}
	
}
