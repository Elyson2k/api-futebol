package com.racha.project.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HISTORICO")
public class HistoricoVotos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idVotante;

    private Integer idVotado;

    public HistoricoVotos(){};

    public HistoricoVotos(Integer id, Integer idVotante, Integer idVotado) {
        this.id = id;
        this.idVotante = idVotante;
        this.idVotado = idVotado;
    }

    public Integer getId() {
        return id;
    }

    public HistoricoVotos setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getIdVotante() {
        return idVotante;
    }

    public HistoricoVotos setIdVotante(Integer idVotante) {
        this.idVotante = idVotante;
        return this;
    }

    public Integer getIdVotado() {
        return idVotado;
    }

    public HistoricoVotos setIdVotado(Integer idVotado) {
        this.idVotado = idVotado;
        return this;
    }
}
