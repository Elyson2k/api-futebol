package com.racha.project.service;

import com.racha.project.entities.HistoricoVotos;
import com.racha.project.entities.Jogador;
import com.racha.project.entities.Partida;
import com.racha.project.entities.dto.*;
import com.racha.project.enums.Status;
import com.racha.project.repository.HistoricoVotosRepository;
import com.racha.project.repository.JogadorRepository;
import com.racha.project.service.exceptions.JogadorExceptions;
import com.racha.project.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogadorService {

	private final JogadorRepository jogadorRepository;

	private final PartidaService partidaService;

	private final HistoricoVotosRepository historicoVotosRepository;

	public JogadorService(JogadorRepository jogadorRepository, PartidaService partidaService, HistoricoVotosRepository historicoVotosRepository) {
		this.jogadorRepository = jogadorRepository;
		this.partidaService = partidaService;
		this.historicoVotosRepository = historicoVotosRepository;
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
		Jogador jogador = new Jogador(null, jogPost.getNome(), null, jogPost.getTipoJogador(),jogPost.getStatus(), jogPost.getNivelJogador());
		jogadorRepository.save(jogador);
		return jogador;
	}


	public Jogador insertDiretamente(Integer idJogador, Integer idPartida){
		Partida partida = partidaService.findById(idPartida);
		Jogador jogador = findById(idJogador);

		if(partida.getJogadores().size() >= partida.getQtdJogadores()) {
			throw new JogadorExceptions("ERROR: Partida cheia, por favor procure outra partida.");
		}
		if(jogador.getStatus().equals(Status.INATIVO)) {
			throw new JogadorExceptions("ERROR: Jogador INATIVO, não pode ser inserido");
		}
		partida.getJogadores().add(jogador);
		jogador.setPartida(partida);
		return jogadorRepository.save(jogador);
	}
	
	public Jogador update(JogadorPatch jogadorDto) {
		Jogador obj = findById(jogadorDto.getId());
		obj.setNome(jogadorDto.getNome());
		Partida partida = partidaService.findById(jogadorDto.getPartidaId());
		if(jogadorDto.getPartidaId() != null) {
			obj.setPartida(partida);
		}
		if(jogadorDto.getTipoJogador() != null) {
			obj.setTipoJogador(jogadorDto.getTipoJogador());
		}
		return jogadorRepository.save(obj);
	}

	public void alterarStatusInativo(Integer alterar){
		Jogador jogador = findById(alterar);
		jogador.setStatus(Status.INATIVO);
		jogador.setPartida(null);
		jogador.setTipoJogador(null);
		jogadorRepository.save(jogador);
	}

	public void alterarStatusAtivo(Integer alterar){
		Jogador jogador = findById(alterar);
		jogador.setStatus(Status.ATIVO);
		jogadorRepository.save(jogador);
	}

	public void jogadorVotar(Integer idVotante, Integer idVotado, Votos votos){
		Jogador votante = findById(idVotante);
		Jogador votado = findById(idVotado);
		votado.setNivelJogador((votado.getNivelJogador() + votos.getVotar()) / 2);
		HistoricoVotos historico = new HistoricoVotos();
		historico.setIdVotante(votante.getId());
		historico.setIdVotado(votado.getId());
		jogadorRepository.saveAll(Arrays.asList(votante,votado));
		historicoVotosRepository.save(historico);
	}

	public List<HistoricoVotosDTO> findAllVotes(){
		List<HistoricoVotos> listHistorico = historicoVotosRepository.findAll();
		return listHistorico.stream().map(jogador1 -> new HistoricoVotosDTO(jogador1)).collect(Collectors.toList());
	}

	
	public void delete(Integer id) {
		findById(id);
		jogadorRepository.deleteById(id);
	}
	
}
