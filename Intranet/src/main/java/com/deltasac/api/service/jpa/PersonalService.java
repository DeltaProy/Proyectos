package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Personal;
import com.deltasac.api.repository.PersonalRepository;
import com.deltasac.api.service.IPersonalService;

@Service
public class PersonalService implements IPersonalService{
	
	@Autowired
	private PersonalRepository repoPersonal;

	@Override
	public List<Personal> buscarTodos() {
		return repoPersonal.findAll();
	}

	@Override
	public void guardar(Personal personal) {
		repoPersonal.save(personal);
	}

	@Override
	public void eliminar(Integer idPersonal) {
		repoPersonal.deleteById(idPersonal);
	}	

}
