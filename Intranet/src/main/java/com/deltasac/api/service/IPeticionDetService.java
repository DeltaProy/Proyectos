package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.PeticionDet;
import com.deltasac.api.entity.PeticionDetPK;

public interface IPeticionDetService {

	List<PeticionDet> buscarTodos();
	void guardar(PeticionDet peticionDet);
	void eliminar(PeticionDetPK PeticionDetPK);
	PeticionDet buscarId(PeticionDetPK PeticionDetPK);
	List<PeticionDet> buscarPorPeticion(Integer idPeticion);
}
