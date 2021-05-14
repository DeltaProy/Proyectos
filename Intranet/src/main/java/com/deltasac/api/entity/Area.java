package com.deltasac.api.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "mae_areas")
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idarea;
	private String desarea;
	@OneToMany(mappedBy = "idarea", cascade = CascadeType.ALL)
	private List<Cargo> cargos;
	
	public Integer getIdarea() {
		return idarea;
	}
	public void setIdarea(Integer idArea) {
		this.idarea = idArea;
	}
	public String getDesarea() {
		return desarea;
	}
	public void setDesarea(String desArea) {
		this.desarea = desArea;
	}
	public List<Cargo> getCargos(){
		return cargos;
	}
	
	
	@Override
	public String toString() {
		return "Area [idarea=" + idarea + ", desarea=" + desarea + "]";
	}

}
