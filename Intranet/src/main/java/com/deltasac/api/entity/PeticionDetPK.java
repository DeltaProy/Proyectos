package com.deltasac.api.entity;

import java.io.Serializable;
import java.util.Date;

public class PeticionDetPK implements Serializable{
    private Integer idpeticion;
	private Date fecha_mov;
	
	public PeticionDetPK() {
		super();
	}
	public PeticionDetPK(Integer idpeticion, Date fechamov) {
		super();
		this.idpeticion = idpeticion;
		this.fecha_mov = fechamov;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha_mov == null) ? 0 : fecha_mov.hashCode());
		result = prime * result + ((idpeticion == null) ? 0 : idpeticion.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeticionDetPK other = (PeticionDetPK) obj;
		if (fecha_mov == null) {
			if (other.fecha_mov != null)
				return false;
		} else if (!fecha_mov.equals(other.fecha_mov))
			return false;
		if (idpeticion == null) {
			if (other.idpeticion != null)
				return false;
		} else if (!idpeticion.equals(other.idpeticion))
			return false;
		return true;
	}
	public Integer getIdpeticion() {
		return idpeticion;
	}
	public void setIdpeticion(Integer idpeticion) {
		this.idpeticion = idpeticion;
	}
	public Date getFecha_mov() {
		return fecha_mov;
	}
	public void setFecha_mov(Date fecha_mov) {
		this.fecha_mov = fecha_mov;
	}
	@Override
	public String toString() {
		return "PeticionDetPK [idpeticion=" + idpeticion + ", fecha_mov=" + fecha_mov + "]";
	}
	
	
	
}
