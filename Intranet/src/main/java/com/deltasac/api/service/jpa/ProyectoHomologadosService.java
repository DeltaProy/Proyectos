package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.ProyectoHomologado;
import com.deltasac.api.entity.ProyectoHomologadoPK;
import com.deltasac.api.repository.ProyectoHomologadosRepository;
import com.deltasac.api.service.IProyectoHomologadosService;

@Service
public class ProyectoHomologadosService implements IProyectoHomologadosService{
	
	@Autowired
	private ProyectoHomologadosRepository repoProyectoHomologado;

	@Override
	public List<ProyectoHomologado> buscarTodos() {
		return repoProyectoHomologado.findAll();
	}

	@Override
	public void guardar(ProyectoHomologado proyectoHomologado) {
		repoProyectoHomologado.save(proyectoHomologado);
	}

	@Override
	public void eliminar(ProyectoHomologadoPK proyectoHomologadoPK) {
		repoProyectoHomologado.deleteById(proyectoHomologadoPK);
	}

	@Override
	public ProyectoHomologado buscarPorId(ProyectoHomologadoPK proyectoHomologadoPK) {
		return repoProyectoHomologado.findById(proyectoHomologadoPK).orElse(null);
	}	

}
