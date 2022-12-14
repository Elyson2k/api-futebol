package com.racha.project.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.racha.project.entities.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.racha.project.service.JogadorService;

//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/jogadores")
public class JogadorController {

	private final JogadorService jogadorService;

	public JogadorController(JogadorService jogadorService) {
		this.jogadorService = jogadorService;
	}

	@GetMapping
	public ResponseEntity<List<JogadorALL>> findAll(){
		List<JogadorALL> listAll = jogadorService.findAll();
		return ResponseEntity.ok(listAll);
	}

	@GetMapping(value = "/votos")
	public ResponseEntity<List<HistoricoVotosDTO>> findVotosById(){
		List<HistoricoVotosDTO> list = jogadorService.findAllVotes();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<JogadorDTO> findById(@PathVariable Integer id){
		return ResponseEntity.ok(new JogadorDTO(jogadorService.findById(id)));
	}



//	LOGGER.info("m=init stage=init, id:{}", id);
//	var pidValidationResponse = PidValidationConverter.fromEntityToInitResponseV2(
//		pidValidationAttemptService.createFirstAttempt(productType, document, request.getName()));
//	LOGGER.info("m=init stage=finish, key:{}, hash:{}", pidValidationResponse.getNextStep().getKey(), pidValidationResponse.getHash());
//	return pidValidationResponse;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody JogadorPOST partPOST){
		var id = jogadorService.insert(partPOST).getId();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PostMapping("/{idJogador}/partida/{idPartida}")
	public ResponseEntity<Void> insertNaPartida(@PathVariable Integer idPartida, @PathVariable Integer idJogador){
		jogadorService.insertDiretamente(idJogador,idPartida);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/{idVotante}/votar/{idVotado}")
	public ResponseEntity<Void> insertNaPartida(@PathVariable Integer idVotante, @PathVariable Integer idVotado, @RequestBody Votos votos){
		jogadorService.jogadorVotar(idVotante,idVotado,votos);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody JogadorPatch obj){
		obj.setId(id);
		var newObj1 = jogadorService.update(obj);		
		JogadorPatch newObj2 = new JogadorPatch(newObj1);
		return ResponseEntity.ok().build();
	}

	@PutMapping(value = "/{id}/inativar")
	public ResponseEntity<Void> updateStatusInativo(@PathVariable Integer id){
		jogadorService.alterarStatusInativo(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping(value = "/{id}/ativar")
	public ResponseEntity<Void> updateStatusAtivo(@PathVariable Integer id){
		jogadorService.alterarStatusAtivo(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){	
		jogadorService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
