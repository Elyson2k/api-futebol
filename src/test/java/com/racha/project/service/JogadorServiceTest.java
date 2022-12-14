package com.racha.project.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.racha.project.enums.Status;
import com.racha.project.enums.TipoJogador;
import com.racha.project.repository.PartidaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.racha.project.entities.Jogador;
import com.racha.project.entities.Partida;
import com.racha.project.entities.dto.JogadorALL;
import com.racha.project.entities.dto.JogadorPOST;
import com.racha.project.entities.dto.JogadorPatch;
import com.racha.project.repository.JogadorRepository;

class JogadorServiceTest {

	private static final int ID_JOGADOR = 1;
	@InjectMocks
	private JogadorService jogadorService;
	@Mock
	private JogadorRepository jogadorRepository;

	@Mock
	private PartidaService partidaService;

	private Optional<Jogador> optionalJogador;
	private JogadorPOST jogadorPOST;
	private Jogador jogador;
	private Jogador jogadorInsert;
	private JogadorPatch jogadorPatch;
	private PartidaRepository partidaRepository;
	private Optional<Partida> optionalPartida;
	private Partida partida;
	
	
	@BeforeEach
	void setUp() throws ParseException {
		MockitoAnnotations.openMocks(this);
		startUser();
		when(jogadorRepository.findAll())
				.thenReturn(List.of(jogador));
		when(jogadorRepository.findById(1))
				.thenReturn(optionalJogador);
		when(jogadorRepository.findById(2))
				.thenReturn(Optional.empty());
		when(jogadorRepository.save(jogadorInsert))
				.thenReturn(jogador);
		when(partidaService.findById(jogadorPatch.getPartidaId()))
				.thenReturn(partida);
	}

	@Test
	@DisplayName("Busca todos os jogadores")
	void testFindAll() {
		List<JogadorALL> response = jogadorService.findAll();
		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals("Elyson", response.get(0).getNome());
	}

	@Test
	@DisplayName("Encontra um jogador por ID quando ID é valido")
	void testFindById() {
		Jogador response = jogadorService.findById(ID_JOGADOR);
		assertNotNull(response);
		assertEquals(Jogador.class, response.getClass());
		assertEquals(jogador.getId(), response.getId());
		assertEquals(jogador.getNome(), response.getNome());
	}

	@Test
	void testInsert() {
		Jogador response = jogadorService.insert(jogadorPOST);

		assertNotNull(response);
		assertEquals(Jogador.class, response.getClass());
		assertEquals(jogador.getNome(), response.getNome());
	}

	@Test
	void testUpdateCompleto() {
		when(jogadorRepository.findById(Mockito.any())).thenReturn(optionalJogador);
		when(jogadorRepository.save(Mockito.any())).thenReturn(jogador);

		Jogador response = jogadorService.update(jogadorPatch);

		assertNotNull(response);
		assertEquals(Jogador.class, response.getClass());
		assertEquals(jogadorPatch.getNome(), response.getNome());
	}

	@Test
	void testUpdateParcial() {
		Jogador jogadorPatchParcial = jogador.clone()
				.setNome("Gabriel");
		when(jogadorRepository.findById(Mockito.any())).thenReturn(optionalJogador);
		when(jogadorRepository.save(Mockito.any())).thenReturn(jogadorPatchParcial);

		jogadorPatch.setNome("Gabriel");
		jogadorPatch.setPartidaId(null);

		Jogador response = jogadorService.update(jogadorPatch);

		assertNotNull(response);
		assertEquals(Jogador.class, response.getClass());
		assertEquals(jogadorPatch.getNome(), response.getNome());
	}

	@Test
	void testDelete() {
		when(jogadorRepository.findById(Mockito.any())).thenReturn(optionalJogador);
		doNothing().when(jogadorRepository).deleteById(Mockito.anyInt());
		jogadorService.delete(ID_JOGADOR);
		verify(jogadorRepository, times(1)).deleteById(Mockito.anyInt());
	}
	
	private void startUser() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		partida = new Partida(10, "Quadra 1", sdf.parse("25/02/2003"),5);
		optionalJogador = Optional.of(new Jogador(ID_JOGADOR,"Elyson", partida, TipoJogador.JOGADOR, Status.ATIVO, 5.0));
		jogador = new Jogador(ID_JOGADOR, "Elyson", partida, TipoJogador.JOGADOR, Status.ATIVO, 5.0);
		jogadorInsert = new Jogador(null, "Elyson", partida, TipoJogador.JOGADOR, Status.ATIVO, 5.0);
		jogadorPatch = new JogadorPatch(ID_JOGADOR, "Elyson", 10, TipoJogador.JOGADOR);
		jogadorPOST = new JogadorPOST("Elyson", TipoJogador.JOGADOR, 10.0);
	}
}
