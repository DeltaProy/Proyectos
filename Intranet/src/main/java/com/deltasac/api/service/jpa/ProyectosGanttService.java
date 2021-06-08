package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.ProyectoGantt;
import com.deltasac.api.repository.ProyectosGanttRepository;
import com.deltasac.api.service.IProyectosGanttService;

@Service
public class ProyectosGanttService implements IProyectosGanttService{
	
	@Autowired
	private ProyectosGanttRepository repoProyectoGantt;

	@Override
	public List<ProyectoGantt> buscarTodos() {
		return repoProyectoGantt.findAll();
	}

	@Override
	public void guardar(ProyectoGantt proyectoGantt) {
		repoProyectoGantt.save(proyectoGantt);
	}

	@Override
	public void eliminar(Integer idProyectoGantt) {
		repoProyectoGantt.deleteById(idProyectoGantt);
	}

	@Override
	public ProyectoGantt buscarPorId(Integer idProyectoGantt) {
		return repoProyectoGantt.findById(idProyectoGantt).orElse(null);
	}	

}
