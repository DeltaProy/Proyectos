package com.deltasac.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.deltasac.api.entity.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Integer>{

}
