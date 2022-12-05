package com.racha.project.service;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.racha.project.entities.Partida;
import com.racha.project.entities.dto.PartidaALL;
import com.racha.project.entities.dto.PartidaDTO;
import com.racha.project.entities.dto.PartidaPOST;
import com.racha.project.repository.PartidaRepository;
import com.racha.project.service.exceptions.ObjectNotFoundException;

class PartidaServiceTest {

	private static final int ID = 1;
	@InjectMocks
	private PartidaService partidaService;
	@Mock
	private PartidaRepository partidaRepository;
	private Partida partida;
	private PartidaPOST partidaPOST;
	private PartidaDTO partidaDto;
	private Optional<Partida> optionalPartida;
	@SuppressWarnings("unused")
	private PartidaALL partidaALL;
	
	
	@BeforeEach
	void setUp() throws ParseException {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	@Test
	void testErrorObjetoNaoEncontrado() {
		when(partidaRepository.findById(Mockito.anyInt())).thenThrow(new ObjectNotFoundException("ERROR: ID não encontrado no sistema."));
		try {
			partidaService.findById(ID);
		}catch(Exception ex) {
			assertEquals(ObjectNotFoundException.class, ex.getClass());
			assertEquals("ERROR: ID não encontrado no sistema.", ex.getMessage());
		}
	}
	

//	@Test
//	void testFind() {
//		when(partidaRepository.findById(Mockito.anyInt())).thenReturn(optionalPartida);
//		PartidaDTO response = partidaService.findById(optionalPartida.get().getId());
//		assertNotNull(response);
//		assertEquals(PartidaDTO.class, response.getClass());
//		assertEquals("Quadra 2", response.getLocal());
//	}
	
	@Test
	void testFindAll() {
		when(partidaRepository.findAll()).thenReturn(List.of(partida));
		List<PartidaALL> response = partidaService.findAll();
		assertNotNull(response);
		assertEquals(ID, response.size());
		assertEquals(PartidaALL.class, response.get(0).getClass());
		assertEquals("Quadra 1", response.get(0).getLocal());
	}

	@Test
	void testInsert() {
		when(partidaRepository.save(Mockito.any())).thenReturn(partida);
		
		Partida response = partidaService.insert(partidaPOST);
		
		assertNotNull(response);
		assertEquals(Partida.class, response.getClass());
		assertEquals("Quadra 1", response.getLocal());
	}
	
	
	

	@Test
	void testUpdate() {
		when(partidaRepository.getReferenceById(Mockito.any())).thenReturn(partida);
		when(partidaRepository.save(Mockito.any())).thenReturn(partida);
		
		Partida response = partidaService.update(partidaDto);
		
		
		assertNotNull(response);
		assertEquals(Partida.class, response.getClass());
		assertEquals("Quadra 1", response.getLocal());
	}

	@Test
	void testDelete() {
		when(partidaRepository.findById(Mockito.any())).thenReturn(optionalPartida);
		doNothing().when(partidaRepository).deleteById(Mockito.anyInt());
		partidaService.delete(ID);
		verify(partidaRepository, times(1)).deleteById(Mockito.anyInt());
	}

	
	private void startUser() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		partida = new Partida(ID,"Quadra 1", sdf.parse("25/02/2003"));
		partidaDto = new PartidaDTO(ID,"Quadra 1", sdf.parse("25/02/2003"));
		optionalPartida = Optional.of(new Partida(ID,"Quadra 2", sdf.parse("25/02/2003")));
		partidaALL = new PartidaALL(ID,"Quadra 1", sdf.parse("25/02/2003"));
		partidaPOST = new PartidaPOST("Quadra 1", sdf.parse("25/02/2003"));
		
	}
	
}
