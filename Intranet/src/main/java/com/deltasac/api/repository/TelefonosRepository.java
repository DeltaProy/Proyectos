package com.deltasac.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.api.entity.Telefono;
import com.deltasac.api.entity.TelefonoPK;

public interface TelefonosRepository extends JpaRepository<Telefono, TelefonoPK>{
	@Transactional
	@Modifying
	@Query("UPDATE Telefono t SET t.estadotelefono = 'E' WHERE t.idpersonal=?1 AND t.estadotelefono= 'A'")
	public void eliminarPorPersonal(int idPersonal);
	
	@Query("SELECT max(t.nrotelf) FROM Telefono t WHERE t.idpersonal=?1")
	public Integer buscarUltimoNrotelf(Integer idPersonal);
	
	@Query("SELECT t FROM Telefono t WHERE t.estadotelefono = 'A'")
	public List<Telefono> buscarTelefonos();
}
