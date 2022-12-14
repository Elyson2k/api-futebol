package com.racha.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PARTIDA")
public class Partida implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String local;
	private Date horas;
	private Integer qtdJogadores;
	
	@JsonIgnore
	@OneToMany(mappedBy = "partida")
	private Set<Jogador> jogadores = new HashSet<>();

	public Partida() {
	}

	public Partida(Integer id, String local, Date horas, Integer qtdJogadores) {
		this.id = id;
		this.local = local;
		this.horas = horas;
		this.qtdJogadores = (qtdJogadores==null) ? null : qtdJogadores;
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

	public void setLocal(String nome) {
		this.local = nome;
	}

	public void setHoras(Date horas) {
		this.horas = horas;
	}

	
	
	public Set<Jogador> getJogadores() {
		return jogadores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(horas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		return Objects.equals(horas, other.horas);
	}

	public Integer getQtdJogadores() {
		return qtdJogadores;
	}

	public void setQtdJogadores(Integer qtdJogadores) {
		this.qtdJogadores = qtdJogadores;
	}
}
