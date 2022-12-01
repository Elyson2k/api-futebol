package com.racha.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.racha.project.entities.Jogador;
import com.racha.project.entities.Partida;
import com.racha.project.repository.JogadorRepository;
import com.racha.project.repository.PartidaRepository;

@Service
public class DBService{

	@Autowired
	private PartidaRepository partidaRepository;
	@Autowired
	private JogadorRepository jogadorRepository;
	
	
	
	@Bean
	public void instantiateTestDataBase() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Partida p1 = new Partida(null, "Quadra Poliesportiva", sdf.parse("10/05/2022 10:30"));
		Partida p2 = new Partida(null, "Campo Gramado", sdf.parse("11/05/2022 09:30"));
		Partida p3 = new Partida(null, "Quadra SantaCruz", sdf.parse("09/05/2022 08:00"));
		Partida p4 = new Partida(null, "Ginasio SportClub", sdf.parse("25/06/2022 11:30"));
		
		Jogador jog1 = new Jogador(null, "Vinicius", p1);
		Jogador jog2 = new Jogador(null, "Pedro", p1);
		Jogador jog3 = new Jogador(null, "Carlos", p1);
		Jogador jog4 = new Jogador(null, "Patricio", p2);
		Jogador jog5 = new Jogador(null, "Ricardo", p2);
		Jogador jog6 = new Jogador(null, "Joao", p3);
		Jogador jog7 = new Jogador(null, "Augusto", p3);
		Jogador jog8 = new Jogador(null, "Paulo",  p3);
		Jogador jog9 = new Jogador(null, "Micaias",  p3);
		Jogador jog10 = new Jogador(null, "Glauber", p4);
		
		jog1.getPosicoes().add("MAT/GOL");
		jog2.getPosicoes().add("ZC/MAT");
		jog3.getPosicoes().add("MAT/ZC");
		jog4.getPosicoes().add("LE/GOL");
		jog5.getPosicoes().add("LD/MAT");
		jog6.getPosicoes().add("VOL/ZC");
		jog7.getPosicoes().add("ZC/VOL");
		jog8.getPosicoes().add("MAT/GOL");
		jog9.getPosicoes().add("MAT/VOL");
		jog10.getPosicoes().add("GOL/MAT");
		
		
		partidaRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		jogadorRepository.saveAll(Arrays.asList(jog1,jog2,jog3,jog4,jog5,jog6,jog7,jog8,jog9,jog10));
		
	}
	
}
