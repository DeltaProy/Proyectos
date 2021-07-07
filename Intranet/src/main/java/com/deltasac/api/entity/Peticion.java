package com.deltasac.api.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ges_peticion")
public class Peticion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpeticion;
	private String titulo;
	private String despeticion;
	private Integer idarea;
	private Integer idusuario;
	private Integer idasignado;
	private String estado;
	@OneToMany(mappedBy = "idpeticion")
	private List<PeticionDet> detalles;
	
	
	public Integer getIdpeticion() {
		return idpeticion;
	}
	public void setIdpeticion(Integer idpeticion) {
		this.idpeticion = idpeticion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDespeticion() {
		return despeticion;
	}
	public void setDespeticion(String despeticion) {
		this.despeticion = despeticion;
	}
	public Integer getIdarea() {
		return idarea;
	}
	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public Integer getIdasignado() {
		return idasignado;
	}
	public void setIdasignado(Integer idasignado) {
		this.idasignado = idasignado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<PeticionDet> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<PeticionDet> detalles) {
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "Peticion [idpeticion=" + idpeticion + ", titulo=" + titulo + ", despeticion=" + despeticion
				+ ", idarea=" + idarea + ", idusuario=" + idusuario + ", idasignado=" + idasignado + ", estado="
				+ estado + ", detalles=" + detalles + "]";
	}
	
	
	
	
}
