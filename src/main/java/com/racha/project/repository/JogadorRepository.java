package com.racha.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.racha.project.entities.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer>{

}
