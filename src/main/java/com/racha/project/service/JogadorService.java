package com.racha.project.service;

import com.racha.project.entities.Jogador;
import com.racha.project.entities.Partida;
import com.racha.project.entities.dto.JogadorALL;
import com.racha.project.entities.dto.JogadorPOST;
import com.racha.project.entities.dto.JogadorPUT;
import com.racha.project.repository.JogadorRepository;
import com.racha.project.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogadorService {

	private final JogadorRepository jogadorRepository;

	private final PartidaService partidaService;

	public JogadorService(JogadorRepository jogadorRepository, PartidaService partidaService) {
		this.jogadorRepository = jogadorRepository;
		this.partidaService = partidaService;
	}


	public List<JogadorALL> findAll(){
		List<Jogador> obj = jogadorRepository.findAll();
		return obj.stream().map(x -> new JogadorALL(x)).collect(Collectors.toList());
	}
	
	public Jogador findById(Integer id) {
		return jogadorRepository.findById(id)
				.orElseThrow( () -> {
					// LOG ERROR AQUI
					return new ObjectNotFoundException("ERROR: ID do Jogador não encontrado no sistema.");
				});
	}

	public Jogador insert(JogadorPOST jogPost) {
		Partida partida = new Partida(jogPost.getPartidaId(), null, null);
		Jogador jogador = new Jogador(null, jogPost.getNome(), partida);

		jogador.getPosicoes().add(jogPost.getPos1());
		if (jogPost.getPos2() != null) {
			jogador.getPosicoes().add(jogPost.getPos2());
		}
		return jogadorRepository.save(jogador);
	}
	
	public Jogador update(JogadorPUT jogadorDto) {
		Jogador obj = findById(jogadorDto.getId());
		obj.setNome(jogadorDto.getNome());
		Partida partida = partidaService.findById(jogadorDto.getPartidaId());
		if(jogadorDto.getPartidaId() != null) {
			obj.setPartida(partida);
		}
		if(jogadorDto.getPosicao() != null) {
			obj.getPosicoes().add(jogadorDto.getPosicao());
		}
		return jogadorRepository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		jogadorRepository.deleteById(id);
	}
	
}
