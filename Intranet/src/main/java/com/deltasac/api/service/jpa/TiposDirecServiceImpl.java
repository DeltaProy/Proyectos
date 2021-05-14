package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.TipoDirec;
import com.deltasac.api.repository.TiposDirecRepository;
import com.deltasac.api.service.ITiposDirecService;

@Service
public class TiposDirecServiceImpl implements ITiposDirecService{
	
	@Autowired
	private TiposDirecRepository repoTipoDirec;

	@Override
	public List<TipoDirec> buscarTodos() {
		return repoTipoDirec.findAll();
	}

	@Override
	public void guardar(TipoDirec tipoDirec) {
		repoTipoDirec.save(tipoDirec);
	}

	@Override
	public void eliminar(int idTipoDirec) {
		repoTipoDirec.deleteById(idTipoDirec);
	}

	

}
