package com.deltasac.api.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ges_peticion_det")
@IdClass(value = PeticionDetPK.class)
public class PeticionDet {
	@Id
	private Integer idpeticion;
	@Id
	private Date fecha_mov;
	private Integer id_usuario;
	private String estado_ant;
	private String estado_act;
	private String observacion;
	
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
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getEstado_ant() {
		return estado_ant;
	}
	public void setEstado_ant(String estado_ant) {
		this.estado_ant = estado_ant;
	}
	public String getEstado_act() {
		return estado_act;
	}
	public void setEstado_act(String estado_act) {
		this.estado_act = estado_act;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@Override
	public String toString() {
		return "PeticionDet [idpeticion=" + idpeticion + ", fecha_mov=" + fecha_mov + ", id_usuario=" + id_usuario
				+ ", estado_ant=" + estado_ant + ", estado_act=" + estado_act + ", observacion=" + observacion + "]";
	}
	
	
}
