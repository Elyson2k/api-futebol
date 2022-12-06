package com.racha.project.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.racha.project.entities.dto.JogadorALL;
import com.racha.project.entities.dto.JogadorDTO;
import com.racha.project.entities.dto.JogadorPOST;
import com.racha.project.entities.dto.JogadorPUT;
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
//	@ApiOperation(value="Retorna uma lista de partidas")
	public ResponseEntity<List<JogadorALL>> findAll(){
		List<JogadorALL> listAll = jogadorService.findAll();
		return ResponseEntity.ok(listAll);
	}
	
	@GetMapping(value = "/{id}")
//	@ApiOperation(value="Retorna uma unica partida")
	public ResponseEntity<JogadorDTO> findById(@PathVariable Integer id){
		return ResponseEntity.ok(new JogadorDTO(jogadorService.findById(id)));
	}

//	LOGGER.info("m=init stage=init, id:{}", id);
//	var pidValidationResponse = PidValidationConverter.fromEntityToInitResponseV2(
//		pidValidationAttemptService.createFirstAttempt(productType, document, request.getName()));
//	LOGGER.info("m=init stage=finish, key:{}, hash:{}", pidValidationResponse.getNextStep().getKey(), pidValidationResponse.getHash());
//	return pidValidationResponse;
	
	@PostMapping
//	@ApiOperation(value="Inserir uma partida")
	public ResponseEntity<Void> insert(@Valid @RequestBody JogadorPOST partPOST){
		var id = jogadorService.insert(partPOST).getId();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@SuppressWarnings("unused")
	@PutMapping(value = "/{id}")
//	@ApiOperation(value="Atualiza uma partida")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody JogadorPUT obj){
		obj.setId(id);
		var newObj1 = jogadorService.update(obj);		
		JogadorPUT newObj2 = new JogadorPUT(newObj1);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
//	@ApiOperation(value="Exclui uma partida")
	public ResponseEntity<Void> delete(@PathVariable Integer id){	
		jogadorService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
