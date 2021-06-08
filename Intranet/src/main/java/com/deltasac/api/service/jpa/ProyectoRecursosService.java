package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.ProyectoRecurso;
import com.deltasac.api.entity.ProyectoRecursoPK;
import com.deltasac.api.repository.ProyectoRecursosRepository;
import com.deltasac.api.service.IProyectoRecursosService;

@Service
public class ProyectoRecursosService implements IProyectoRecursosService{
	
	@Autowired
	private ProyectoRecursosRepository repoProyectoRecurso;

	@Override
	public List<ProyectoRecurso> buscarTodos() {
		return repoProyectoRecurso.findAll();
	}

	@Override
	public void guardar(ProyectoRecurso proyectoRecurso) {
		repoProyectoRecurso.save(proyectoRecurso);
	}

	@Override
	public void eliminar(ProyectoRecursoPK proyectoRecursoPK) {
		repoProyectoRecurso.deleteById(proyectoRecursoPK);
	}

	@Override
	public ProyectoRecurso buscarPorId(ProyectoRecursoPK proyectoRecursoPK) {
		return repoProyectoRecurso.findById(proyectoRecursoPK).orElse(null);
	}	

}
