package com.deltasac.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.dao.TipoDocDao;
import com.deltasac.domain.TipoDoc;

@Service
public class TipoDocServiceImpl implements TipoDocService{
	
	@Autowired
	private TipoDocDao tipoDocDao;

	@Override
	@Transactional(readOnly = true)
	public List<TipoDoc> listarTipoDocs() {
		return (List<TipoDoc>) tipoDocDao.findAll();
	}

	@Override
	public void guardarTipoDoc(TipoDoc tipoDoc) {
		tipoDocDao.save(tipoDoc);
	}

	@Override
	public void eliminarTipoDoc(TipoDoc tipoDoc) {
		tipoDocDao.delete(tipoDoc);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoDoc encontrarTipoDoc(TipoDoc tipoDoc) {
		return null; /*tipoDocDao.findById(tipoDoc.getIdTipoDoc()).orElse(null);*/
	}

}
