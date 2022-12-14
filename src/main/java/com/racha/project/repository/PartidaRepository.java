package com.racha.project.repository;

import com.racha.project.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import com.racha.project.entities.Partida;
import org.springframework.data.repository.Repository;

public interface PartidaRepository extends JpaRepository<Partida, Integer>{

}
