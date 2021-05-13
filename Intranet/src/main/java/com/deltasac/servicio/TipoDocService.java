package com.deltasac.servicio;

import java.util.List;

import com.deltasac.domain.TipoDoc;

public interface TipoDocService {

	public List<TipoDoc> listarTipoDocs();
	
	public void guardarTipoDoc(TipoDoc tipoDoc);
	
	public void eliminarTipoDoc(TipoDoc tipoDoc);
	
	public TipoDoc encontrarTipoDoc(TipoDoc tipoDoc);
}
