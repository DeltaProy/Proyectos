package com.deltasac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deltasac.api.entity.Empresa;

public interface EmpresasRepository extends JpaRepository<Empresa, Integer> {

}
