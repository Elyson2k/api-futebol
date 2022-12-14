package com.racha.project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.racha.project.entities.dto.PartidaALL;
import com.racha.project.entities.dto.PartidaDTO;
import com.racha.project.entities.dto.PartidaPOST;
import com.racha.project.service.PartidaService;

//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/partidas")
public class PartidaController {
	private final PartidaService partidaService;

	public PartidaController(PartidaService partidaService) {
		this.partidaService = partidaService;
	}

	@GetMapping
	public ResponseEntity<List<PartidaALL>> findAll(){
		List<PartidaALL> listAll = partidaService.findAll();
		return ResponseEntity.ok(listAll);
	}

	@GetMapping("/disponivel")
	public ResponseEntity<List<PartidaALL>> findDisponivel(){
		List<PartidaALL> listAll = partidaService.findAll();
		return ResponseEntity.ok(listAll);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PartidaDTO> find(@PathVariable Integer id){
		return ResponseEntity.ok(new PartidaDTO(partidaService.findById(id)));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PartidaPOST partPOST){
		var id = partidaService.insert(partPOST).getId();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PatchMapping(value = "/{id}")
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
