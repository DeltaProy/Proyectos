package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.ProyectoTarea;
import com.deltasac.api.entity.ProyectoTareaPK;
import com.deltasac.api.repository.ProyectoTareasRepository;
import com.deltasac.api.service.IProyectoTareasService;

@Service
public class ProyectoTareasService implements IProyectoTareasService{
	
	@Autowired
	private ProyectoTareasRepository repoProyectoTarea;

	@Override
	public List<ProyectoTarea> buscarTodos() {
		return repoProyectoTarea.findAll();
	}

	@Override
	public void guardar(ProyectoTarea proyectoTarea) {
		repoProyectoTarea.save(proyectoTarea);
	}

	@Override
	public void eliminar(ProyectoTareaPK proyectoTareaPK) {
		repoProyectoTarea.deleteById(proyectoTareaPK);
	}

	@Override
	public ProyectoTarea buscarPorId(ProyectoTareaPK proyectoTareaPK) {
		return repoProyectoTarea.findById(proyectoTareaPK).orElse(null);
	}

	@Override
	public void eliminarPorProyecto(int idProyecto) {
		repoProyectoTarea.eliminarPorProyecto(idProyecto);
		
	}	

}
