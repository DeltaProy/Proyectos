package com.deltasac.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "mae_areas")
public class Area implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;
	
	private String desArea;
	
	@OneToMany(mappedBy = "area")
	private List<Cargo> cargos;
	
	public Area () {
	}
	
	public Area (String desArea) {
		this.desArea = desArea;
	}

}
