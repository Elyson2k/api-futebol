package com.racha.project.repository;

import com.racha.project.entities.HistoricoVotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoVotosRepository extends JpaRepository<HistoricoVotos,Integer> {
}
