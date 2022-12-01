package com.racha.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racha.project.entities.Partida;
import com.racha.project.entities.dto.PartidaALL;
import com.racha.project.entities.dto.PartidaDTO;
import com.racha.project.entities.dto.PartidaPOST;
import com.racha.project.repository.PartidaRepository;
import com.racha.project.service.exceptions.EmptyResultDataAccessException;
import com.racha.project.service.exceptions.ObjectNotFoundException;

@Service
public class PartidaService {
	
	@Autowired
	private PartidaRepository partidaRepository;
	
	public List<PartidaALL> findAll(){
		return partidaRepository.findAll().stream().map(obj -> new PartidaALL(obj)).collect(Collectors.toList());
	}
	
	public PartidaDTO find(Integer id) {
		Optional<Partida> obj = partidaRepository.findById(id);
		var newObj = obj.orElseThrow( () -> new ObjectNotFoundException("ERROR: ID não cadastrado no sistema.") );
		return new PartidaDTO(newObj);
	}
	
	public Partida insert(PartidaPOST partida) {
		Partida obj = new Partida();
		obj.setId(null);
		obj.setLocal(partida.getLocal());
		obj.setHoras(partida.getHoras());
		return partidaRepository.save(obj);
	}
		
	public Partida update(PartidaDTO partida) {
		Optional<Partida> obj = partidaRepository.findById(partida.getId());
		obj.get().setLocal(partida.getLocal());
		if(partida.getHoras() != null) {
			obj.get().setHoras(partida.getHoras());
		}
		return partidaRepository.save(obj.get());
	}
	
	public void delete(Integer id) {
		try {
			partidaRepository.deleteById(id);
		} catch (RuntimeException e) {
			throw new EmptyResultDataAccessException("ERROR: Não pode excluir essa entidade.");
		}
	}
	
}
