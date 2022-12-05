package com.racha.project.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.racha.project.entities.Jogador;
import com.racha.project.entities.Partida;
import com.racha.project.entities.dto.JogadorALL;
import com.racha.project.entities.dto.JogadorDTO;
import com.racha.project.entities.dto.JogadorPOST;
import com.racha.project.entities.dto.JogadorPUT;
import com.racha.project.repository.JogadorRepository;
import com.racha.project.repository.PartidaRepository;

class JogadorServiceTest {

	private static final int ID = 1;
	@InjectMocks
	private JogadorService jogadorService;
	@Mock
	private JogadorRepository jogadorRepository;
	private Optional<Jogador> optionalJogador;
	private JogadorPOST jogadorPOST;
	private Jogador jogador;
	private JogadorPUT jogadorPUT;
	private PartidaRepository partidaRepository;
	private Optional<Partida> optionalPartida;
	private Partida partida;
	
	
	@BeforeEach
	void setUp() throws ParseException {
		MockitoAnnotations.openMocks(this);
		startUser();
	}
	
	@Test
	void testFindAll() {
		when(jogadorRepository.findAll()).thenReturn(List.of(jogador));
		List<JogadorALL> response = jogadorService.findAll();
		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals("Elyson", response.get(0).getNome());
	}

	@Test
	void testFind() {
		when(jogadorRepository.findById(Mockito.anyInt())).thenReturn(optionalJogador);
		JogadorDTO response = jogadorService.find(optionalJogador.get().getId());
		assertNotNull(response);
		assertEquals(JogadorDTO.class, response.getClass());
		assertEquals("Quadra 1", response.getPartida().getLocal());		
	}

	@Test
	void testInsert() {
		when(jogadorRepository.save(Mockito.any())).thenReturn(jogador);
		Jogador response = jogadorService.insert(jogadorPOST);
		
		assertNotNull(response);
		assertEquals(Jogador.class, response.getClass());
		assertEquals("Elyson", response.getNome());
	}

	@Test
	void testUpdate() {
		when(jogadorRepository.findById(Mockito.any())).thenReturn(optionalJogador);
		when(jogadorRepository.save(Mockito.any())).thenReturn(jogador);
		
		Jogador response = jogadorService.update(jogadorPUT);
		
		assertNotNull(response);
		assertEquals(Jogador.class, response.getClass());
		assertEquals("Quadra 1", response.getPartida().getLocal());
		assertEquals("Elyson", response.getNome());
		
	}

	@Test
	void testDelete() {
		when(jogadorRepository.findById(Mockito.any())).thenReturn(optionalJogador);
		doNothing().when(jogadorRepository).deleteById(Mockito.anyInt());
		jogadorService.delete(ID);
		verify(jogadorRepository, times(1)).deleteById(Mockito.anyInt());
		
	}
	
	private void startUser() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		partida = new Partida(10, "Quadra 1", sdf.parse("25/02/2003"));
		optionalJogador = Optional.of(new Jogador(ID,"Elyson", partida));
		jogador = new Jogador(ID, "Elyson", partida);
		jogadorPUT = new JogadorPUT(ID, "Elyson", 10, "MAT");
		jogadorPOST = new JogadorPOST("Elyson", "MAT", "GOL", 10);
		
	}

}
