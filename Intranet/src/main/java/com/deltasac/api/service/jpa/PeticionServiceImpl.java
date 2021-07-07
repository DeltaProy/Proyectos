package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Peticion;
import com.deltasac.api.repository.PeticionRepository;
import com.deltasac.api.service.IPeticionService;

@Service
public class PeticionServiceImpl implements IPeticionService{
	
	@Autowired
	private PeticionRepository repoPeticion;

	@Override
	public List<Peticion> buscarTodos() {
		return repoPeticion.findAll();
	}

	@Override
	public void guardar(Peticion peticion) {
		repoPeticion.save(peticion);
	}

	@Override
	public void eliminar(Integer idPeticion) {
		repoPeticion.deleteById(idPeticion);
	}

	@Override
	public Peticion buscarId(Integer idPeticion) {
		return repoPeticion.findById(idPeticion).orElse(null);
	}


	@Override
	public List<Peticion> buscarbuscarPeticionPorArea(Integer idArea) {
		return repoPeticion.buscarPeticionPorArea(idArea);
	}

	@Override
	public List<Peticion> buscarbuscarPeticionPorAsignado(Integer idAsignado) {
		return repoPeticion.buscarPeticionPorAsignado(idAsignado);
	}

	@Override
	public List<Peticion> buscarbuscarPeticionPorUsuario(Integer idUsuario) {
		return repoPeticion.buscarPeticionPorUsuario(idUsuario);
	}
}
