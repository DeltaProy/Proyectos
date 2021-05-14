package com.deltasac.api.entity;

import java.io.Serializable;

public class CargoPK implements Serializable{
    private Integer idcargo;
	private Integer idarea;
	
	public CargoPK() {
		super();
	}

	public CargoPK(Integer idcargo, Integer idarea) {
		super();
		this.idcargo = idcargo;
		this.idarea = idarea;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idarea == null) ? 0 : idarea.hashCode());
		result = prime * result + ((idcargo == null) ? 0 : idcargo.hashCode());
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
		CargoPK other = (CargoPK) obj;
		if (idarea == null) {
			if (other.idarea != null)
				return false;
		} else if (!idarea.equals(other.idarea))
			return false;
		if (idcargo == null) {
			if (other.idcargo != null)
				return false;
		} else if (!idcargo.equals(other.idcargo))
			return false;
		return true;
	}
	public Integer getIdcargo() {
		return idcargo;
	}
	public void setIdcargo(Integer idcargo) {
		this.idcargo = idcargo;
	}
	public Integer getArea() {
		return idarea;
	}
	public void setArea(Integer area) {
		this.idarea = area;
	}
	
	
	
}
