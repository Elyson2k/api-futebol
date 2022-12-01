package com.racha.project.entities.dto;

import java.io.Serializable;
import java.util.Date;

import com.racha.project.entities.Partida;

public class PartidaALL implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String local;
	private Date horas;
	
	public PartidaALL() {};
	
	public PartidaALL(Partida obj) {
		this.id = obj.getId();
		this.local = obj.getLocal();
		this.horas = obj.getHoras();
	}
	
	
	public Integer getId() {
		return id;
	}
	public String getLocal() {
		return local;
	}
	public Date getHoras() {
		return horas;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public void setHoras(Date horas) {
		this.horas = horas;
	}
	
}
