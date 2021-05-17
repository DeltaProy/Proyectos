package com.deltasac.api.entity;

import javax.persistence.*;

@Entity
@Table(name="ges_telefonos")
@IdClass(value = TelefonoPK.class)
public class Telefono {

	@Id
	private Integer idpersonal;
	@Id
	private Integer nrotelf;
	private Integer idtipotelf;
	private String discado;
	private String nroanexo;
	
	public Integer getIdpersonal() {
		return idpersonal;
	}
	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}
	public Integer getNrotelf() {
		return nrotelf;
	}
	public void setNrotelf(Integer nrotelf) {
		this.nrotelf = nrotelf;
	}
	public Integer getIdtipotelf() {
		return idtipotelf;
	}
	public void setIdtipotelf(Integer idtipotelf) {
		this.idtipotelf = idtipotelf;
	}
	public String getDiscado() {
		return discado;
	}
	public void setDiscado(String discado) {
		this.discado = discado;
	}
	public String getNroanexo() {
		return nroanexo;
	}
	public void setNroanexo(String nroanexo) {
		this.nroanexo = nroanexo;
	}
	
	@Override
	public String toString() {
		return "Telefonos [idpersonal=" + idpersonal + ", nrotelf=" + nrotelf + ", idtipotelf=" + idtipotelf
				+ ", discado=" + discado + ", nroanexo=" + nroanexo + "]";
	}
	
	
			
}