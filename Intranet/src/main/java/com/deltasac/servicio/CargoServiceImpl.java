package com.deltasac.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.dao.CargoDao;
import com.deltasac.domain.Cargo;

@Service
public class CargoServiceImpl implements CargoService{
	
	@Autowired
	private CargoDao cargoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> listarCargos() {
		return (List<Cargo>) cargoDao.findAll();
	}

	@Override
	public void guardarCargo(Cargo cargo) {
		cargoDao.save(cargo);
	}

	@Override
	public void eliminarCargo(Cargo cargo) {
		cargoDao.delete(cargo);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo encontrarCargo(Cargo cargo) {
		return null;
		/*cargoDao.findById(cargo.getIdCargo()).orElse(null);*/
	}

}
