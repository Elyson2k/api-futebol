package com.racha.project.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "JOGADOR")
public class Jogador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ElementCollection
	@CollectionTable(name = "POSICAO")
	private Set<String> posicoes = new HashSet<>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PARTIDA_ID")
	private Partida partida;
	
	public Jogador() {};
	
	public Jogador(Integer id, String nome, Partida partida) {
		super();
		this.id = id;
		this.nome = nome;
		this.partida = partida;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
