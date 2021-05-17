package com.deltasac.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deltasac.api.entity.Ubigeo;

public interface UbigeosRepository extends JpaRepository<Ubigeo, String> {
	
	@Query("SELECT DISTINCT u.departamento FROM Ubigeo u")
	public List<String> buscarDepartamentos();
	
	@Query("SELECT DISTINCT u.provincia FROM Ubigeo u WHERE u.departamento=?1")
	public List<String> buscarProvinciasPorDep(String departamento);
	
	@Query("SELECT DISTINCT u.distrito FROM Ubigeo u WHERE u.departamento=?1 AND u.provincia=?2")
	public List<String> buscarDistritoPorDepProv(String departamento, String provincia);
	
	@Query("SELECT u.idubigeo FROM Ubigeo u WHERE u.departamento=?1 AND u.provincia=?2 AND u.distrito=?3")
	public String buscarUbigeo(String departamento, String provincia, String distrito);
}
