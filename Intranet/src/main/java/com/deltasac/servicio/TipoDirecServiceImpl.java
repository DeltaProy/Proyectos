package com.deltasac.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.dao.TipoDirecDao;
import com.deltasac.domain.TipoDirec;

@Service
public class TipoDirecServiceImpl implements TipoDirecService{
	
	@Autowired
	private TipoDirecDao tipoDirecDao;

	@Override
	@Transactional(readOnly = true)
	public List<TipoDirec> listarTipoDirecs() {
		return (List<TipoDirec>) tipoDirecDao.findAll();
	}

	@Override
	public void guardarTipoDirec(TipoDirec tipoDirec) {
		tipoDirecDao.save(tipoDirec);
	}

	@Override
	public void eliminarTipoDirec(TipoDirec tipoDirec) {
		tipoDirecDao.delete(tipoDirec);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoDirec encontrarTipoDirec(TipoDirec tipoDirec) {
		return tipoDirecDao.findById(tipoDirec.getIdTipoDir()).orElse(null);
	}

}
