package com.racha.project.entities.dto;

import com.racha.project.entities.Jogador;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;

public class PartidaPOST {
	
	private String local;
	@Column(unique = true)
	private Date horas;
	private Integer qtdJogadores;


	public PartidaPOST(String local, Date horas, Integer qtdJogadores) {
		super();
		this.local = local;
		this.horas = horas;
		this.qtdJogadores = qtdJogadores;
	}

	public PartidaPOST() {}

	public String getLocal() {
		return local;
	}

	public Date getHoras() {
		return horas;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void setHoras(Date horas) {
		this.horas = horas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(horas, local);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartidaPOST other = (PartidaPOST) obj;
		return Objects.equals(horas, other.horas) && Objects.equals(local, other.local);
	};

	public Integer getQtdJogadores() {
		return qtdJogadores;
	}


	public void setQtdJogadores(Integer qtdJogadores) {
		this.qtdJogadores = qtdJogadores;
	}
}
