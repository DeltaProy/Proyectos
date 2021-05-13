package com.deltasac.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.dao.AreaDao;
import com.deltasac.domain.Area;

@Service
public class AreaServiceImpl implements AreaService{
	
	@Autowired
	private AreaDao areaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Area> listarAreas() {
		return (List<Area>) areaDao.findAll();
	}

	@Override
	public void guardarArea(Area area) {
		areaDao.save(area);
	}

	@Override
	public void eliminarArea(Area area) {
		areaDao.delete(area);
	}

	@Override
	@Transactional(readOnly = true)
	public Area encontrarArea(Area area) {
		return areaDao.findById(area.getIdArea()).orElse(null);
	}

}
