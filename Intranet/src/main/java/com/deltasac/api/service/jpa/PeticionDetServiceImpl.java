package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.PeticionDet;
import com.deltasac.api.entity.PeticionDetPK;
import com.deltasac.api.repository.PeticionDetRepository;
import com.deltasac.api.service.IPeticionDetService;

@Service
public class PeticionDetServiceImpl implements IPeticionDetService{
	
	@Autowired
	private PeticionDetRepository repoPeticionDet;

	@Override
	public List<PeticionDet> buscarTodos() {
		return repoPeticionDet.findAll();
	}

	@Override
	public void guardar(PeticionDet peticionDet) {
		repoPeticionDet.save(peticionDet);
	}

	@Override
	public void eliminar(PeticionDetPK peticionDetPK) {
		repoPeticionDet.deleteById(peticionDetPK);
	}

	@Override
	public PeticionDet buscarId(PeticionDetPK peticionDetPK) {
		return repoPeticionDet.findById(peticionDetPK).orElse(null);
	}

	@Override
	public List<PeticionDet> buscarPorPeticion(Integer idPeticion) {
		return repoPeticionDet.buscarPorPeticion(idPeticion);
	}

	

}
