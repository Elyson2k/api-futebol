package com.racha.project.entities.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class Votos implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double votar;

    @JsonCreator
    public Votos(Double votar) {
        this.votar = votar;
    }

    public Double getVotar() {
        return votar;
    }

    public Votos setVotar(Double votar) {
        this.votar = votar;
        return this;
    }
}