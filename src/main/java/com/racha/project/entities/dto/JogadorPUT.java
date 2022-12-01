package com.racha.project.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.racha.project.entities.Jogador;

public class JogadorPUT implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Set<String> posicoes = new HashSet<>();
	private Integer partidaId;
	private String posicao;
	
	public JogadorPUT() {};
	
	public JogadorPUT(Jogador obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.partidaId = obj.getPartida().getId();
		this.posicoes = obj.getPosicoes();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Set<String> getPosicoes() {
		return posicoes;
	}

	public Integer getPartidaId() {
		return partidaId;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPosicoes(Set<String> posicoes) {
		this.posicoes = posicoes;
	}

	public void setPartidaId(Integer partidaId) {
		this.partidaId = partidaId;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
}
