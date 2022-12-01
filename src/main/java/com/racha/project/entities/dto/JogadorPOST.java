package com.racha.project.entities.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class JogadorPOST implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatorio.")
	@Length(min = 4, max = 15, message = "Comprimento minimo : 4 letras / maximo : 15")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatorio.")
	@Length(min = 2, max = 3, message = "Comprimento minimo : 3 letras / maximo : 3")
	private String pos1;
	private String pos2;
	private Integer partidaId;
	
	public JogadorPOST() {}

	
	public String getNome() {
		return nome;
	}

	public String getPos1() {
		return pos1;
	}

	public Integer getPartidaId() {
		return partidaId;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPos1(String pos) {
		this.pos1 = pos;
	}

	public void setPartidaId(Integer partidaId) {
		this.partidaId = partidaId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, partidaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogadorPOST other = (JogadorPOST) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(partidaId, other.partidaId);
	}

	public String getPos2() {
		return pos2;
	}

	public void setPos2(String pos2) {
		this.pos2 = pos2;
	};

	
	
}
