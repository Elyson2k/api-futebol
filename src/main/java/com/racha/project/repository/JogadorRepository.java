package com.racha.project.repository;

import com.racha.project.entities.Jogador;
import com.racha.project.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador,Integer> {
}
