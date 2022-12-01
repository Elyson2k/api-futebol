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

import com.racha.project.entities.dto.JogadorALL;
import com.racha.project.entities.dto.JogadorDTO;
import com.racha.project.entities.dto.JogadorPOST;
import com.racha.project.entities.dto.JogadorPUT;
import com.racha.project.service.JogadorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/jogadores")
public class JogadorController {

	@Autowired
	private JogadorService jogadorService;
	
	@GetMapping
	public ResponseEntity<List<JogadorALL>> findAll(){
		List<JogadorALL> listAll = jogadorService.findAll();
		return ResponseEntity.ok(listAll);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<JogadorDTO> find(@PathVariable Integer id){
		JogadorDTO obj = jogadorService.find(id);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody JogadorPOST partPOST){
		var id = jogadorService.insert(partPOST).getId();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@SuppressWarnings("unused")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id, @RequestBody JogadorPUT obj){
		obj.setId(id);
		var newObj1 = jogadorService.update(obj);		
		JogadorPUT newObj2 = new JogadorPUT(newObj1);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){	
		jogadorService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}