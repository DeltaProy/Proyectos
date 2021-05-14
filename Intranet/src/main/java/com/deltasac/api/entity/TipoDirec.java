package com.deltasac.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "mae_tipos_direc")
public class TipoDirec {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtipodir;
	private String destipodir;

	public Integer getIdtipodir() {
		return idtipodir;
	}

	public void setIdtipodir(Integer idTipoDir) {
		this.idtipodir = idTipoDir;
	}

	public String getDestipodir() {
		return destipodir;
	}

	public void setDestipodir(String desTipoDir) {
		this.destipodir = desTipoDir;
	}

	@Override
	public String toString() {
		return "TipoDirec [idtipodir=" + idtipodir + ", desTipoDir=" + destipodir + "]";
	}
	
	
}
