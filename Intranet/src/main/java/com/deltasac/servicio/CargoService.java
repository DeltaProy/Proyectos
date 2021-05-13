package com.deltasac.servicio;

import java.util.List;

import com.deltasac.domain.Cargo;

public interface CargoService {

	public List<Cargo> listarCargos();
	
	public void guardarCargo(Cargo cargo);
	
	public void eliminarCargo(Cargo cargo);
	
	public Cargo encontrarCargo(Cargo cargo);
}
