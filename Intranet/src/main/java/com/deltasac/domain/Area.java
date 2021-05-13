package com.deltasac.domain;

import javax.persistence.*;

@Entity
@Table(name = "mae_areas")
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;
	private String desArea;
	
	public Long getIdArea() {
		return idArea;
	}
	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}
	public String getDesArea() {
		return desArea;
	}
	public void setDesArea(String desArea) {
		this.desArea = desArea;
	}
	
	
	@Override
	public String toString() {
		return "Area [idArea=" + idArea + ", desArea=" + desArea + "]";
	}

}
