package com.deltasac.api.entity;

import javax.persistence.*;

@Entity
@Table(name="mae_tipos_soft")
public class TipoSoft {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tpo_soft")
	private Integer idtiposoft;
	@Column(name = "des_tpo_soft")
	private String destiposoft;
	
	public Integer getIdtiposoft() {
		return idtiposoft;
	}
	public void setIdtiposoft(Integer idtiposoft) {
		this.idtiposoft = idtiposoft;
	}
	public String getDestiposoft() {
		return destiposoft;
	}
	public void setDestiposoft(String destiposoft) {
		this.destiposoft = destiposoft;
	}
	
	@Override
	public String toString() {
		return "TipoSoft [idtiposoft=" + idtiposoft + ", destiposoft=" + destiposoft + "]";
	}
	
	
}