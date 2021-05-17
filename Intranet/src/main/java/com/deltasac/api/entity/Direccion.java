package com.deltasac.api.entity;

import javax.persistence.*;

@Entity
@Table(name="ges_direcciones")
@IdClass(value = DireccionPK.class)
public class Direccion {

	@Id
	private Integer idpersonal;
	@Id
	private Integer nrodir;
	private Integer idtipodir;
	private String desdireccion;
	private String idubigeo;
	
	
	public Integer getIdpersonal() {
		return idpersonal;
	}
	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}
	public Integer getNrodir() {
		return nrodir;
	}
	public void setNrodir(Integer nrodir) {
		this.nrodir = nrodir;
	}
	public Integer getIdtipodir() {
		return idtipodir;
	}
	public void setIdtipodir(Integer idtipodir) {
		this.idtipodir = idtipodir;
	}
	public String getDesdireccion() {
		return desdireccion;
	}
	public void setDesdireccion(String desdireccion) {
		this.desdireccion = desdireccion;
	}
	public String getIdubigeo() {
		return idubigeo;
	}
	public void setIdubigeo(String idubigeo) {
		this.idubigeo = idubigeo;
	}
	
	@Override
	public String toString() {
		return "Direccion [idpersonal=" + idpersonal + ", nrodir=" + nrodir + ", idtipodir=" + idtipodir
				+ ", desdireccion=" + desdireccion + ", idubigeo=" + idubigeo + "]";
	}	
	
			
}