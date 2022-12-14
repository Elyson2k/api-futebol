package com.racha.project.entities.dto;

import java.io.Serializable;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.racha.project.entities.Jogador;
import com.racha.project.entities.Partida;
import com.racha.project.enums.Status;
import com.racha.project.enums.TipoJogador;

public class JogadorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private TipoJogador tipoJogador;
	private Partida partida;
	private Status status;
	private Double nivelJogador;

	@JsonIgnore
	private Map<String, Integer> votos = new HashMap<>();

	public JogadorDTO() {};
	
	public JogadorDTO(Jogador obj) {
		super();
		this.id = obj.getId();
		this.status = obj.getStatus();
		this.nome = obj.getNome();
		this.nivelJogador = obj.getNivelJogador();
		this.tipoJogador = obj.getTipoJogador();
		this.partida = obj.getPartida();

	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public TipoJogador getTipoJogador() {
		return tipoJogador;
	}

	public JogadorDTO setTipoJogador(TipoJogador tipoJogador) {
		this.tipoJogador = tipoJogador;
		return this;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}


	public Status getStatus() {
		return status;
	}

	public JogadorDTO setStatus(Status status) {
		this.status = status;
		return this;
	}

	public Double getNivelJogador() {
		return nivelJogador;
	}

	public JogadorDTO setNivelJogador(Double nivelJogador) {
		this.nivelJogador = nivelJogador;
		return this;
	}

	public Map<String, Integer> getVotos() {
		return votos;
	}

	public JogadorDTO setVotos(Map<String, Integer> votos) {
		this.votos = votos;
		return this;
	}
}
