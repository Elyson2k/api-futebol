package com.racha.project.entities.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.racha.project.entities.HistoricoVotos;

import java.io.Serializable;

public class HistoricoVotosDTO implements Serializable {

    private Integer idVotante;
    private Integer idVotado;

    public HistoricoVotosDTO(){};

    @JsonCreator
    public HistoricoVotosDTO(Integer idVotante, Integer idVotado) {
        this.idVotante = idVotante;
        this.idVotado = idVotado;
    }

    public HistoricoVotosDTO(HistoricoVotos historico) {
        this.idVotante = historico.getIdVotante();
        this.idVotado = historico.getIdVotado();
    }

    public Integer getIdVotante() {
        return idVotante;
    }

    public HistoricoVotosDTO setNomeVotante(Integer idVotante) {
        this.idVotante = idVotante;
        return this;
    }

    public Integer getIdVotado() {
        return idVotado;
    }

    public HistoricoVotosDTO setNomeVotado(Integer idVotado) {
        this.idVotado = idVotado;
        return this;
    }
}
