package com.deltasac.api.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="ges_proy_gantt")
public class ProyectoGantt {

	@Id
	private Integer idproyecto;
	private Integer duracion;
	private Integer avanceEst;
	private Integer avanceReal;
	private String fileSubido;
	private Date fecActFile;
	private Integer usrActFile;
	
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public Integer getAvanceEst() {
		return avanceEst;
	}
	public void setAvanceEst(Integer avanceEst) {
		this.avanceEst = avanceEst;
	}
	public Integer getAvanceReal() {
		return avanceReal;
	}
	public void setAvanceReal(Integer avanceReal) {
		this.avanceReal = avanceReal;
	}
	public String getFileSubido() {
		return fileSubido;
	}
	public void setFileSubido(String fileSubido) {
		this.fileSubido = fileSubido;
	}
	public Date getFecActFile() {
		return fecActFile;
	}
	public void setFecActFile(Date fecActFile) {
		this.fecActFile = fecActFile;
	}
	public Integer getUsrActFile() {
		return usrActFile;
	}
	public void setUsrActFile(Integer usrActFile) {
		this.usrActFile = usrActFile;
	}
	
	@Override
	public String toString() {
		return "ProyectoGantt [idproyecto=" + idproyecto + ", duracion=" + duracion + ", avanceEst=" + avanceEst
				+ ", avanceReal=" + avanceReal + ", fileSubido=" + fileSubido + ", fecActFile=" + fecActFile
				+ ", usrActFile=" + usrActFile + "]";
	}
	
	
}
