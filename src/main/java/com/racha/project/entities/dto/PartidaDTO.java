package com.racha.project.entities.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.racha.project.entities.Jogador;
import com.racha.project.entities.Partida;

public class PartidaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String local;
	private Date horas;
	private Set<Jogador> jogadores = new HashSet<>();
	
	public PartidaDTO() {};
	
	public PartidaDTO(Partida obj) {
		this.id = obj.getId();
		this.local = obj.getLocal();
		this.horas = obj.getHoras();
		this.jogadores = obj.getJogadores();
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
	public Set<Jogador> getJogadores() {
		return jogadores;
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
	public void setJogadores(Set<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
}
