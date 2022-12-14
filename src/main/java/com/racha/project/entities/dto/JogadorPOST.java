package com.racha.project.entities.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.racha.project.enums.Status;
import com.racha.project.enums.TipoJogador;
import org.hibernate.validator.constraints.Length;

public class JogadorPOST implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatorio.")
	@Length(min = 4, max = 15, message = "Comprimento minimo : 4 letras / maximo : 15")
	private String nome;

	private TipoJogador tipoJogador;
	private Status status = Status.ATIVO;
    @NotNull(message = "Campo não pode ser nulo")
	private Double nivelJogador;
	
	public JogadorPOST(
			@NotEmpty(message = "Preenchimento obrigatorio.") @Length(min = 4, max = 15, message = "Comprimento minimo : 4 letras / maximo : 15") String nome,
			@NotEmpty(message = "Preenchimento obrigatorio.") @Length(min = 2, max = 3, message = "Comprimento minimo : 3 letras / maximo : 3")
			TipoJogador tipoJogador, Double nivelJogador) {
		super();
		this.nome = nome;
		this.tipoJogador = tipoJogador;
		this.nivelJogador = nivelJogador;
	}


	public JogadorPOST() {}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoJogador getTipoJogador() {
		return tipoJogador;
	}

	public JogadorPOST setTipoJogador(TipoJogador tipoJogador1) {
		this.tipoJogador = tipoJogador1;
		return this;
	}

	public Status getStatus() {
		return status;
	}

	public JogadorPOST setStatus(Status status) {
		this.status = status;
		return this;
	}


	public Double getNivelJogador() {
		return nivelJogador;
	}

	public JogadorPOST setNivelJogador(Double nivelJogador) {
		this.nivelJogador = nivelJogador;
		return this;
	}
}
