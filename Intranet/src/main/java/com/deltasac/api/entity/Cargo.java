package com.deltasac.api.entity;

import javax.persistence.*;


@Entity
@Table(name = "mae_cargos")
@IdClass(value = CargoPK.class)
public class Cargo{
	@Id
    private Integer idcargo;
	@Id
	private Integer idarea;
	
	private String descargo;

	public Integer getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(Integer idCargo) {
		this.idcargo = idCargo;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public String getDescargo() {
		return descargo;
	}

	public void setDescargo(String descargo) {
		this.descargo = descargo;
	}

	@Override
	public String toString() {
		return "Cargo [idcargo=" + idcargo + ", idarea=" + idarea + ", descargo=" + descargo + "]";
	}
	
	
}
