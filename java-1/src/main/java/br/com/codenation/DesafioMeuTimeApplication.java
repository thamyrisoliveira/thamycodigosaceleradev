package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.model.Jogador;
import br.com.codenation.model.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	private ArrayList<Time> times = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		validaIdentificador(times, Time::getId,id);
		times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Time time = recuperarTimePorId(idTime);
		validaIdentificador(time.getJogadores(), Jogador::getId,id);
		time.add(new Jogador(id, idTime,nome,dataNascimento,nivelHabilidade, salario));
	}

	public void definirCapitao(Long idJogador) {
		if (times.isEmpty()) {
			throw new JogadorNaoEncontradoException();
		}
		times.forEach(time -> {
			Jogador jogador = recuperarJogadorPorId(idJogador, time);
			if(jogador == null){
				throw new JogadorNaoEncontradoException();
			}
			time.setCapitao(jogador);
		});

	}


	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = recuperarTimePorId(idTime);
		if(time.getCapitao()== null){
			throw new CapitaoNaoInformadoException();
		}
		return time.getCapitao().getId();
	}

	public String buscarNomeJogador(Long idJogador) {
		Jogador jogadorEncontrado = null;
		for(Time time : times){
			for(Jogador jogador : time.getJogadores()){
				if(jogador.getId() == idJogador ){
					jogadorEncontrado = jogador;
				}
			}
		}
		if(jogadorEncontrado == null){
			throw new JogadorNaoEncontradoException();
		}
		return jogadorEncontrado.getNome();
	}

	public String buscarNomeTime(Long idTime) {
		Time timeEncontrado = recuperarTimePorId(idTime);
		return timeEncontrado.getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Time timeEncontrado = recuperarTimePorId(idTime);
		List<Long> ids = new ArrayList<>();
		for(Jogador jogador : timeEncontrado.getJogadores()){
			ids.add(jogador.getId());
		}
		return ids;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Jogador maisHabilidoso = null;
		Time time = recuperarTimePorId(idTime);
		for( Jogador jogador : time.getJogadores()){
			if(maisHabilidoso != null && maisHabilidoso.getNivelHabilidade() < jogador.getNivelHabilidade()) {
				maisHabilidoso = jogador;
			}
			if(maisHabilidoso == null) {
				maisHabilidoso = jogador;
			}
		}
		return maisHabilidoso.getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		Jogador maisVelho = null;
		Time time = recuperarTimePorId(idTime);
		for( Jogador jogador : time.getJogadores()){
			if(maisVelho != null && (maisVelho.getDataDeNascimento().isAfter(jogador.getDataDeNascimento())
					|| (maisVelho.getDataDeNascimento().equals(jogador.getDataDeNascimento()) && maisVelho.getId() < jogador.getId() ))) {

				maisVelho = jogador;
			}
			if(maisVelho == null) {
				maisVelho = jogador;
			}
		}
		return maisVelho.getId();
	}

	public List<Long> buscarTimes() {
		List<Long> ids = new ArrayList<>();
		times.sort(Comparator.comparing(Time :: getId));
		for(Time time : times){
			ids.add(time.getId());
		}
		return ids;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		Jogador maiorSalario = null;
		Time time = recuperarTimePorId(idTime);
		for( Jogador jogador : time.getJogadores()){
			if((maiorSalario != null && (maiorSalario.getSalario().compareTo(jogador.getSalario()) < 0)
					|| (maiorSalario != null && maiorSalario.getSalario().equals(jogador.getSalario()) && maiorSalario.getId() > jogador.getId()))) {
				maiorSalario = jogador;
			}
			if(maiorSalario == null) {
				maiorSalario = jogador;
			}
		}
		return maiorSalario.getId();

	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Jogador jogador = recuperarJogadorPorId(idJogador);
		return jogador.getSalario();

	}

	public List<Long> buscarTopJogadores(Integer top) {
		ArrayList<Jogador> todosJogadores = new ArrayList<>();
		ArrayList<Long> ids = new ArrayList<>();
		for (Time time : times){
			todosJogadores.addAll(time.getJogadores());
		}
		todosJogadores.sort(Comparator.comparing(Jogador :: getSalario).reversed().thenComparing(Jogador::getId));
		for(Jogador jogador : todosJogadores){
			ids.add(jogador.getId());
		}
		if(ids.isEmpty()){
			return Collections.emptyList();
		}
		return ids.subList(0, top);
	}

	private <T> void validaIdentificador(List<T> lista, Function<T, Long> getter, Long id){
		lista.stream().filter(e -> getter.apply(e) == id).findAny().ifPresent(time -> {throw new IdentificadorUtilizadoException();});

	}
	private Time recuperarTimePorId(Long id){
		Time timeEncontrado = null;
		for(Time time : times){
			if(time.getId() == id){
				timeEncontrado = time;
			}
		}
		if(timeEncontrado == null){
			throw new TimeNaoEncontradoException();
		}
		return timeEncontrado;
	}
	private Jogador recuperarJogadorPorId(Long idJogador, Time time) {
		Jogador jogadorEncontrado = null;
		for(Jogador jogador : time.getJogadores()){
			if(jogador.getId().equals(idJogador)){
				jogadorEncontrado = jogador;
			}
		}
		return jogadorEncontrado;
	}
	private Jogador recuperarJogadorPorId(Long idJogador) {
		Jogador jogadorEncontrado = null;
		for(Time time : times){
			jogadorEncontrado = recuperarJogadorPorId(idJogador, time);
		}
		if(jogadorEncontrado == null){
			throw new JogadorNaoEncontradoException();
		}
		return jogadorEncontrado;
	}

}
