package com.racha.project.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.racha.project.entities.Jogador;
import com.racha.project.enums.TipoJogador;

public class JogadorALL implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;

	private TipoJogador tipoJogador;

	public JogadorALL() {};
	
	public JogadorALL(Jogador obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.tipoJogador = obj.getTipoJogador();
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

	public TipoJogador getTipoJogador() {
		return tipoJogador;
	}

	public JogadorALL setTipoJogador(TipoJogador tipoJogador) {
		this.tipoJogador = tipoJogador;
		return this;
	}

}
