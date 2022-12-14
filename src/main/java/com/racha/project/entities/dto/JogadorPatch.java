package com.racha.project.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.racha.project.entities.Jogador;
import com.racha.project.enums.TipoJogador;

public class JogadorPatch implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private TipoJogador tipoJogador;
	private Integer partidaId;

	public JogadorPatch() {};
	
	
	public JogadorPatch(Integer id, String nome, Integer partidaId, TipoJogador tipoJogador) {
		super();
		this.id = id;
		this.nome = nome;
		this.partidaId = partidaId;
		this.tipoJogador = tipoJogador;
	}



	public JogadorPatch(Jogador obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.partidaId = obj.getPartida().getId();
		this.tipoJogador = obj.getTipoJogador();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getPartidaId() {
		return partidaId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPartidaId(Integer partidaId) {
		this.partidaId = partidaId;
	}

	public TipoJogador getTipoJogador() {
		return tipoJogador;
	}

	public JogadorPatch setTipoJogador(TipoJogador tipoJogador) {
		this.tipoJogador = tipoJogador;
		return this;
	}

	
}
