package com.racha.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.racha.project.enums.Status;
import com.racha.project.enums.TipoJogador;
import com.racha.project.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.racha.project.entities.Jogador;
import com.racha.project.entities.Partida;
import com.racha.project.repository.JogadorRepository;

import javax.transaction.Transactional;

@Service
public class DBService implements CommandLineRunner {

	@Autowired
	private PartidaRepository partidaRepository;
	@Autowired
	private JogadorRepository jogadorRepository;

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Jogador jog1 = new Jogador(null, "Vinicius", null , TipoJogador.JOGADOR, Status.ATIVO, 5.0);
		Jogador jog2 = new Jogador(null, "Pedro", null, TipoJogador.JOGADOR, Status.ATIVO, 5.0);
		Jogador jog3 = new Jogador(null, "Carlos", null, TipoJogador.JOGADOR, Status.ATIVO, 5.0);
		Jogador jog4 = new Jogador(null, "Patricio", null, TipoJogador.JOGADOR, Status.ATIVO, 5.0);
		Jogador jog5 = new Jogador(null, "Ricardo", null, TipoJogador.JOGADOR, Status.ATIVO, 5.0);
		Jogador jog6 = new Jogador(null, "Joao", null, TipoJogador.JOGADOR, Status.ATIVO, 5.0);
		Jogador jog7 = new Jogador(null, "Augusto", null, TipoJogador.JOGADOR, Status.ATIVO, 5.0);
		Jogador jog8 = new Jogador(null, "Paulo",  null, TipoJogador.JOGADOR, Status.ATIVO, 5.0);
		Jogador jog9 = new Jogador(null, "Micaias",  null, TipoJogador.GOLEIRO, Status.ATIVO, 5.0);
		Jogador jog10 = new Jogador(null, "Glauber", null, TipoJogador.GOLEIRO, Status.ATIVO, 5.0);

		jogadorRepository.saveAll(Arrays.asList(jog1,jog2,jog3,jog4,jog5,jog6,jog7,jog8,jog9,jog10));

		Partida p1 = new Partida(null, "Quadra Poliesportiva", sdf.parse("10/05/2022 10:30"),5);
		Partida p2 = new Partida(null, "Campo Gramado", sdf.parse("11/05/2022 09:30"),5);
		Partida p3 = new Partida(null, "Quadra SantaCruz", sdf.parse("09/05/2022 08:00"),5);
		Partida p4 = new Partida(null, "Ginasio SportClub", sdf.parse("25/06/2022 11:30"),5);

		partidaRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

		jog1.setPartida(p1);
		jog2.setPartida(p1);
		jog3.setPartida(p1);
		jog4.setPartida(p2);
		jog5.setPartida(p2);
		jog6.setPartida(p2);
		jog7.setPartida(p3);
		jog8.setPartida(p4);
		jog9.setPartida(p4);
		jog10.setPartida(p4);

	}
}
