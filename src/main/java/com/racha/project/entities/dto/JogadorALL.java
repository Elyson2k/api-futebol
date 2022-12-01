package com.racha.project.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.racha.project.entities.Jogador;

public class JogadorALL implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Set<String> pos = new HashSet<>();
	
	public JogadorALL() {};
	
	public JogadorALL(Jogador obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
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

	public Set<String> getPos() {
		return pos;
	}

	public void setPos(Set<String> pos) {
		this.pos = pos;
	}

}
