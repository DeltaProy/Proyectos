package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Proyecto;
import com.deltasac.api.repository.ProyectosRepository;
import com.deltasac.api.service.IProyectosService;

@Service
public class ProyectosService implements IProyectosService{
	
	@Autowired
	private ProyectosRepository repoProyecto;

	@Override
	public List<Proyecto> buscarTodos() {
		return repoProyecto.findAll();
	}

	@Override
	public void guardar(Proyecto proyecto) {
		repoProyecto.save(proyecto);
	}

	@Override
	public void eliminar(Integer idProyecto) {
		repoProyecto.deleteById(idProyecto);
	}

	@Override
	public Proyecto buscarPorId(int idProyecto) {
		return repoProyecto.findById(idProyecto).orElse(null);
	}

	@Override
	public Proyecto buscarPorNombre(String nombreProyecto) {
		return repoProyecto.buscarPorNombre(nombreProyecto);
	}

	@Override
	public List<Proyecto> listarProyectosPorResponsable(int idresponsable) {
		return repoProyecto.listarProyectosPorResponsable(idresponsable);
	}	

}
