package com.deltasac.api.entity;

import javax.persistence.*;

@Entity
@Table(name="mae_software")
public class Software {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_soft")
	private Integer idsoft;
	@Column(name="des_soft")
	private String dessoft;
	@Column(name="id_tpo_soft")
	private Integer idtiposoft;
	
	public Integer getIdsoft() {
		return idsoft;
	}
	public void setIdsoft(Integer idsoft) {
		this.idsoft = idsoft;
	}
	public String getDessoft() {
		return dessoft;
	}
	public void setDessoft(String dessoft) {
		this.dessoft = dessoft;
	}
	public Integer getIdtiposoft() {
		return idtiposoft;
	}
	public void setIdtiposoft(Integer idtiposoft) {
		this.idtiposoft = idtiposoft;
	}
	
	@Override
	public String toString() {
		return "Software [idsoft=" + idsoft + ", dessoft=" + dessoft + ", idtiposoft=" + idtiposoft + "]";
	}
	
	
	
	
}
