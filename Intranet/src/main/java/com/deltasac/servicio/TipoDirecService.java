package com.deltasac.servicio;

import java.util.List;

import com.deltasac.domain.TipoDirec;

public interface TipoDirecService {

	public List<TipoDirec> listarTipoDirecs();
	
	public void guardarTipoDirec(TipoDirec tipoDirec);
	
	public void eliminarTipoDirec(TipoDirec tipoDirec);
	
	public TipoDirec encontrarTipoDirec(TipoDirec tipoDirec);
}
