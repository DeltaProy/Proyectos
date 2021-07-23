package com.deltasac.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deltasac.api.entity.ProyectoGantt;
import com.deltasac.api.service.IPersonalService;
import com.deltasac.api.service.IProyectosGanttService;

import net.sf.mpxj.Duration;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;

@CrossOrigin("http://173.255.202.95:8080")
@RestController
@RequestMapping("/proyectoGantt")
public class ProyectoGanttController {

	@Autowired
	private IProyectosGanttService serviceProyectoGantt;
	@Autowired
	private IPersonalService servicePersonal;
	
	
	@GetMapping("/listar")
	public List<ProyectoGantt> buscarTodos(){
		return serviceProyectoGantt.buscarTodos();
	}
	//Para guardar o actualizar
	@PostMapping("/guardar")
	public Object guardar(@RequestParam("file") MultipartFile file, @RequestParam("idproyecto") Integer idProyecto, @RequestParam("idpersonal") Integer idPersonal) {
		//Check id personal
		if(servicePersonal.buscarPorId(idPersonal) == null) {
			return "El personal con ese id no existe en la base de datos";
		}
		
		ProyectoGantt pg = new ProyectoGantt();
		
		try {
			MPPReader mppRead = new MPPReader();
			ProjectFile pf = mppRead.read(file.getInputStream());
			
			Task mainTask = pf.getChildTasks().get(0);
			
			Double duracionTotal = mainTask.getDuration().getDuration();
			Number avanceReal = mainTask.getPercentageComplete();
			
			// avance_estimado
			Date hoy = new Date();
			Integer avanceEst;
			if(hoy.before(mainTask.getStart())) {
				avanceEst = 0;
			}else if(hoy.after(mainTask.getFinish())) {
				avanceEst = 100;
			}else {
				Integer diasDesdeInicio;
				diasDesdeInicio = hoy.compareTo(mainTask.getStart());
				avanceEst = (diasDesdeInicio/duracionTotal.intValue())*100;
			}
			
			pg.setIdproyecto(idProyecto);
			pg.setDuracion(duracionTotal.intValue());
			pg.setAvanceEst(avanceEst);
			pg.setAvanceReal(avanceReal.intValue());
			pg.setFileSubido(file.getOriginalFilename());
			pg.setFecActFile(new Date());
			pg.setUsrActFile(idPersonal);
			
			serviceProyectoGantt.guardar(pg);
			return pg;
			
		} catch (MPXJException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No se pudo guardar el registro";
		}		
	}
	
	@DeleteMapping("/eliminar")
	public String eliminar(@RequestParam("idproyecto") Integer idproyecto) {
		serviceProyectoGantt.eliminar(idproyecto);
		return "Registro eliminado";
	}
	
}
