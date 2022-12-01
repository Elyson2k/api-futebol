package com.racha.project.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.racha.project.entities.Jogador;
import com.racha.project.entities.Partida;

public class JogadorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Set<String> posicoes = new HashSet<>();
	private Partida partida;
	
	public JogadorDTO() {};
	
	public JogadorDTO(Jogador obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.partida = obj.getPartida();
		this.posicoes = obj.getPosicoes();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
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

	public Set<String> getPosicoes() {
		return posicoes;
	}

	public void setPosicoes(Set<String> pos) {
		this.posicoes = pos;
	}
	
}
