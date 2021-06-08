package com.deltasac.api.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.deltasac.api.entity.Proyecto;
import com.deltasac.api.entity.ProyectoHomologadoPK;
import com.deltasac.api.entity.ProyectoTarea;
import com.deltasac.api.entity.ProyectoTareaPK;
import com.deltasac.api.service.IProyectoHomologadosService;
import com.deltasac.api.service.IProyectoTareasService;

import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;

@RestController
@RequestMapping("/proyectoTareas")
public class ProyectoTareasController {

	@Autowired
	private IProyectoTareasService serviceProyectoTareas;
	@Autowired
	private IProyectoHomologadosService serviceProyectoHomologados;
	
	
	@GetMapping("/listar")
	public List<ProyectoTarea> buscarTodos(){
		return serviceProyectoTareas.buscarTodos();
	}
	
	@PostMapping("/guardar")
	public Object guardar(@RequestParam("file") MultipartFile file, @RequestParam("idproyecto") Integer idProyecto) {
		try {
			MPPReader mppRead = new MPPReader();
			ProjectFile pf = mppRead.read(file.getInputStream());
			
			//CREAR TAREAS
			for(Task task: pf.getTasks()) {
				ProyectoTarea tarea = new ProyectoTarea();
				tarea.setIdproyecto(idProyecto);
				String nombreRecurso = "";
				try {
					nombreRecurso = task.getResourceAssignments().get(0).getResource().getName();										
				} catch (Exception e) {
				}
				tarea.setIdpersonal(serviceProyectoHomologados.buscarPorId(new ProyectoHomologadoPK(idProyecto, nombreRecurso)).getIdpersonal());
				tarea.setDestarea(task.getName());
				tarea.setFecini(task.getStart());
				tarea.setFecfin(task.getFinish());
				tarea.setFecfin_real(task.getActualFinish());
				tarea.setPorc_avance((Double) task.getPercentageWorkComplete());
				
				
				serviceProyectoTareas.guardar(tarea);
			}
			
			return "Tareas creadas";
			
		} catch (MPXJException | IOException e) {
			e.printStackTrace();
		}
		return "Error al guardar proyecto";
	}
	
	@PostMapping("/actualizar")
	public Object actualizar(@RequestParam("file") MultipartFile file, @RequestParam("idproyecto") Integer idProyecto) {
		serviceProyectoTareas.eliminarPorProyecto(idProyecto);
		try {
			MPPReader mppRead = new MPPReader();
			ProjectFile pf = mppRead.read(file.getInputStream());
			
			//CREAR TAREAS
			for(Task task: pf.getTasks()) {
				ProyectoTarea tarea = new ProyectoTarea();
				tarea.setIdproyecto(idProyecto);
				String nombreRecurso = "";
				try {
					nombreRecurso = task.getResourceAssignments().get(0).getResource().getName();										
				} catch (Exception e) {
				}
				tarea.setIdpersonal(serviceProyectoHomologados.buscarPorId(new ProyectoHomologadoPK(idProyecto, nombreRecurso)).getIdpersonal());
				tarea.setDestarea(task.getName());
				tarea.setFecini(task.getStart());
				tarea.setFecfin(task.getFinish());
				tarea.setFecfin_real(task.getActualFinish());
				tarea.setPorc_avance((Double) task.getPercentageWorkComplete());
				
				serviceProyectoTareas.guardar(tarea);
			}
			
			return "Tareas creadas";
			
		} catch (MPXJException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error al guardar proyecto";
	}

	@DeleteMapping("/eliminar")
	public String eliminar(@RequestBody() ProyectoTarea pt) {
		serviceProyectoTareas.eliminar(new ProyectoTareaPK(pt.getIdproyecto(), pt.getIdpersonal(), pt.getNumtarea()));
		return "Registro eliminado";
	}
	
}
