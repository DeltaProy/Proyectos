package com.deltasac.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "mae_cargos")
public class Cargo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    private Long idCargo;
	
	@JoinColumn(name="idArea",referencedColumnName = "idArea")
	@ManyToOne
	private Area area;
}
