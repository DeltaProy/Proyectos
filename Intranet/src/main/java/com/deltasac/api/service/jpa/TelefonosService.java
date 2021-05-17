package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Telefono;
import com.deltasac.api.entity.TelefonoPK;
import com.deltasac.api.repository.TelefonosRepository;
import com.deltasac.api.service.ITelefonosService;

@Service
public class TelefonosService implements ITelefonosService{
	
	@Autowired
	private TelefonosRepository repoTelefono;

	@Override
	public List<Telefono> buscarTodos() {
		return repoTelefono.findAll();
	}

	@Override
	public void guardar(Telefono telefono) {
		repoTelefono.save(telefono);
	}

	@Override
	public void eliminar(TelefonoPK telefonoPK) {
		repoTelefono.deleteById(telefonoPK);
	}	

}
