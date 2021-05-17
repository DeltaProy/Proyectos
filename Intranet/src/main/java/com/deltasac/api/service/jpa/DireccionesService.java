package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Direccion;
import com.deltasac.api.entity.DireccionPK;
import com.deltasac.api.repository.DireccionesRepository;
import com.deltasac.api.service.IDireccionesService;

@Service
public class DireccionesService implements IDireccionesService{
	
	@Autowired
	private DireccionesRepository repoDireccion;

	@Override
	public List<Direccion> buscarTodos() {
		return repoDireccion.findAll();
	}

	@Override
	public void guardar(Direccion direccion) {
		repoDireccion.save(direccion);
	}

	@Override
	public void eliminar(DireccionPK direccionPK) {
		repoDireccion.deleteById(direccionPK);
	}	

}
