package br.com.codenation.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Time {

    private Long id;
    private String nome;
    private LocalDate dataDaCriacao;
    private String corDeUniformePrincipal;
    private String corDeUniformeSecundario;
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private Jogador capitao;

    public Time(Long id, String nome, LocalDate dataDaCriacao, String corDeUniformePrincipal, String corDeUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataDaCriacao = dataDaCriacao;
        this.corDeUniformePrincipal = corDeUniformePrincipal;
        this.corDeUniformeSecundario = corDeUniformeSecundario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDaCriacao() {
        return dataDaCriacao;
    }

    public void setDataDaCriacao(LocalDate dataDaCriacao) {
        this.dataDaCriacao = dataDaCriacao;
    }

    public String getCorDeUniformePrincipal() {
        return corDeUniformePrincipal;
    }

    public void setCorDeUniformePrincipal(String corDeUniformePrincipal) {
        this.corDeUniformePrincipal = corDeUniformePrincipal;
    }

    public String getCorDeUniformeSecundario() {
        return corDeUniformeSecundario;
    }

    public void setCorDeUniformeSecundario(String corDeUniformeSecundario) {
        this.corDeUniformeSecundario = corDeUniformeSecundario;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public Jogador getCapitao() {
        return capitao;
    }

    public void setCapitao(Jogador capitao) {
        this.capitao = capitao;
    }

    public void add(Jogador jogador){
        jogadores.add(jogador);
    }


}

