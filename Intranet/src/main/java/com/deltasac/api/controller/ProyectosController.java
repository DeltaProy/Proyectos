package com.deltasac.api.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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

import com.deltasac.api.entity.Proyecto;
import com.deltasac.api.entity.ProyectoTarea;
import com.deltasac.api.service.IEmpresasService;
import com.deltasac.api.service.IProyectoTareasService;
import com.deltasac.api.service.IProyectosService;

import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;
import net.sf.mpxj.reader.ProjectReader;
import net.sf.mpxj.reader.UniversalProjectReader;


@RestController
@RequestMapping("/proyectos")
public class ProyectosController {

	@Autowired
	private IProyectosService serviceProyecto;
	@Autowired
	private IProyectoTareasService serviceTarea;
	@Autowired
	private IEmpresasService serviceEmpresa;
	
	
	@GetMapping("/listar")
	public List<Proyecto> buscarTodos(){
		return serviceProyecto.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Object guardar(@RequestParam("file") MultipartFile file, @RequestParam("idempresa") Integer idEmpresa) {
		if(serviceEmpresa.buscarPorId(idEmpresa) == null) {
			return "El idEmpresa no existe en la base de datos";
		}
		
		try {
			MPPReader mppRead = new MPPReader();
			ProjectFile pf = mppRead.read(file.getInputStream());
			
			//CREAR PROYECTO
			Proyecto proyecto = new Proyecto();
			proyecto.setIdEmpresa(idEmpresa);
			proyecto.setDesproyecto(pf.getProjectProperties().getProjectTitle());
			proyecto.setFecini(pf.getStartDate());
			proyecto.setFecfin(pf.getFinishDate());
			proyecto.setFecfinreal(pf.getProjectProperties().getActualFinish());
			
			serviceProyecto.guardar(proyecto);
			
			return proyecto;
			
		} catch (MPXJException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error al guardar proyecto";
	}
	
	@PutMapping("/actualizar")
	public Object actualizar(@RequestParam("file") MultipartFile file, @RequestParam("idproyecto") Integer idProyecto) {
		
		Proyecto proyecto = serviceProyecto.buscarPorId(idProyecto);
		
		if(proyecto == null) {
			return "El id del proyecto no existe";
		}
		
		try {
			MPPReader mppRead = new MPPReader();
			ProjectFile pf = mppRead.read(file.getInputStream());
			
			proyecto.setDesproyecto(pf.getProjectProperties().getProjectTitle());
			proyecto.setFecini(pf.getStartDate());
			proyecto.setFecfin(pf.getFinishDate());
			proyecto.setFecfinreal(pf.getProjectProperties().getActualFinish());
			
			serviceProyecto.guardar(proyecto);
			return proyecto;
			
		} catch (MPXJException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error al actualizar el proyecto";
	}
}
