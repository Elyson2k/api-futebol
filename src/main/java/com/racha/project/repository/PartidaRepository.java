package com.racha.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.racha.project.entities.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer>{

}
