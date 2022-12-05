package com.racha.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racha.project.entities.Jogador;
import com.racha.project.entities.Partida;
import com.racha.project.entities.dto.JogadorALL;
import com.racha.project.entities.dto.JogadorDTO;
import com.racha.project.entities.dto.JogadorPOST;
import com.racha.project.entities.dto.JogadorPUT;
import com.racha.project.repository.JogadorRepository;
import com.racha.project.repository.PartidaRepository;
import com.racha.project.service.exceptions.ObjectNotFoundException;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository jogadorRepository;
	@Autowired
	private PartidaRepository partidaRepository;
	
	public List<JogadorALL> findAll(){
		List<Jogador> obj = jogadorRepository.findAll();
		return obj.stream().map(x -> new JogadorALL(x)).collect(Collectors.toList());
	}
	
	public JogadorDTO find(Integer id) {
		Optional<Jogador> obj = jogadorRepository.findById(id);
		var newObj = obj.orElseThrow( () -> new ObjectNotFoundException("ERROR: ID não cadastrado no sistema.") );
		return new JogadorDTO(newObj);
	}

	public Jogador insert(JogadorPOST jogPost) {
		
		Partida partida = new Partida(jogPost.getPartidaId(), null, null);
		Jogador jogador = new Jogador(null, jogPost.getNome(), partida);

		jogador.getPosicoes().add(jogPost.getPos1());
		if (jogPost.getPos2() != null) {
			jogador.getPosicoes().add(jogPost.getPos2());
		}
		jogadorRepository.save(jogador);
		return jogador;
	}
	
	public Jogador update(JogadorPUT jogadorDto) {
		try {
			Optional<Jogador> obj = jogadorRepository.findById(jogadorDto.getId());
			obj.get().setNome(jogadorDto.getNome());
			Optional<Partida> partida = partidaRepository.findById(jogadorDto.getPartidaId());
			if(jogadorDto.getPartidaId() != null) {
				obj.get().setPartida(partida.get());
			}
			if(jogadorDto.getPosicao() != null) {
				obj.get().getPosicoes().add(jogadorDto.getPosicao());
			}
			jogadorRepository.save(obj.get());
			return obj.get();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("ERROR: Não foi possivel encontrar o ID informado.");
		}
	}
	
	public void delete(Integer id) {
		find(id);
		jogadorRepository.deleteById(id);
		
	}
	
}
