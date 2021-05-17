package com.deltasac.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.deltasac.api.entity.Telefono;
import com.deltasac.api.entity.TelefonoPK;

public interface TelefonosRepository extends JpaRepository<Telefono, TelefonoPK>{

}
