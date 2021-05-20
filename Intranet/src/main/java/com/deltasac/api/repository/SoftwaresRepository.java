package com.deltasac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deltasac.api.entity.Software;

public interface SoftwaresRepository extends JpaRepository<Software, Integer> {

}
