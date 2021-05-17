package com.deltasac.api.entity;

import javax.persistence.*;

@Entity
@Table(name="mae_tipos_telfs")
public class TipoTelf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtipotelf;
	private String destipotelef;
	
	public Integer getIdtipotelf() {
		return idtipotelf;
	}
	public void setIdtipotelf(Integer idtipotelf) {
		this.idtipotelf = idtipotelf;
	}
	public String getDestipotelf() {
		return destipotelef;
	}
	public void setDestipotelf(String destipotelef) {
		this.destipotelef = destipotelef;
	}
	
	@Override
	public String toString() {
		return "TipoTelf [idtipotelf=" + idtipotelf + ", destipotelf=" + destipotelef + "]";
	}
		
}