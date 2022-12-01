package com.racha.project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.racha.project.entities.dto.PartidaALL;
import com.racha.project.entities.dto.PartidaDTO;
import com.racha.project.entities.dto.PartidaPOST;
import com.racha.project.service.PartidaService;

@RestController
@RequestMapping(value = "/api/v1/partidas")
public class PartidaController {

	@Autowired
	private PartidaService partidaService;
	
	@GetMapping
	public ResponseEntity<List<PartidaALL>> findAll(){
		List<PartidaALL> listAll = partidaService.findAll();
		return ResponseEntity.ok(listAll);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PartidaDTO> find(@PathVariable Integer id){
		PartidaDTO obj = partidaService.find(id);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PartidaPOST partPOST){
		var id = partidaService.insert(partPOST).getId();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@SuppressWarnings("unused")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody PartidaDTO partPOST){
		partPOST.setId(id);
		var partida = partidaService.update(partPOST);		
		PartidaDTO newObj = new PartidaDTO(partida);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){	
		partidaService.delete(id);
		return ResponseEntity.ok().build();
	}
}
