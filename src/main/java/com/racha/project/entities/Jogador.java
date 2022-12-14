package com.racha.project.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.racha.project.entities.base.Auditable;
import com.racha.project.entities.dto.HistoricoVotosDTO;
import com.racha.project.enums.Status;
import com.racha.project.enums.TipoJogador;

@Entity
@Table(name = "JOGADOR")
public class Jogador extends Auditable<String> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@Enumerated(EnumType.STRING)
	private TipoJogador tipoJogador;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PARTIDA_ID")
	private Partida partida;
	@Enumerated(EnumType.STRING)
	private Status status;
	private Double nivelJogador;

	public Jogador() {};
	
	public Jogador(Integer id, String nome, Partida partida, TipoJogador tipoJogador, Status status, Double nivelJogador) {
		super();
		this.id = id;
		this.nome = nome;
		this.partida = partida;
		this.tipoJogador = tipoJogador;
		this.status = status;
		this.nivelJogador = nivelJogador;
	}

	public Jogador clone() {
		return new Jogador()
				.setId(id)
				.setNome(nome)
				.setPartida(partida)
				.setTipoJogador(tipoJogador);
	}

	public Integer getId() {
		return id;
	}

	public Jogador setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Jogador setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public Partida getPartida() {
		return partida;
	}

	public Jogador setPartida(Partida partida) {
		this.partida = partida;
		return this;
	}

	public TipoJogador getTipoJogador() {
		return tipoJogador;
	}

	public Jogador setTipoJogador(TipoJogador tipoJogador) {
		this.tipoJogador = tipoJogador;
		return this;
	}


	public Status getStatus() {
		return status;
	}

	public Jogador setStatus(Status status) {
		this.status = status;
		return this;
	}

	public Double getNivelJogador() {
		return nivelJogador;
	}

	public Jogador setNivelJogador(Double nivelJogador) {
		this.nivelJogador = nivelJogador;
		return this;
	}

}
