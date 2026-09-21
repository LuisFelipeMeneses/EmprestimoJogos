package br.ufms.luisf.entities.jogo;

import br.ufms.luisf.entities.categoria.Categoria;
import br.ufms.luisf.entities.exemplar.ExemplarJogo;
import br.ufms.luisf.entities.reserva.Reserva;
import br.ufms.luisf.validadores.Validar;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Jogo {
    private UUID id;
    private String nome;
    private String descricao;
    private int numeroMinimoJogadores;
    private int numeroMaximoJogadores;
    private int idadeMinima;
    private int duracaoMinima;
    private int duracaoMaxima;
    private int anoLancamento;
    private String editora;
    private LocalDateTime dataCadastro;
    private boolean ativo;

    public Jogo(UUID id, String nome, String descricao, int numeroMinimoJogadores, int numeroMaximoJogadores, int idadeMinima, int duracaoMinima, int duracaoMaxima, int anoLancamento, String editora, LocalDateTime dataCadastro, boolean ativo) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;

        this(nome, descricao, numeroMinimoJogadores, numeroMaximoJogadores, idadeMinima, duracaoMinima, duracaoMaxima, anoLancamento, editora);
    }
    public Jogo(String nome, String descricao, int numeroMinimoJogadores, int numeroMaximoJogadores, int idadeMinima, int duracaoMinima, int duracaoMaxima) {
        this(nome, descricao, numeroMinimoJogadores, numeroMaximoJogadores, idadeMinima, duracaoMinima, duracaoMaxima, 0, null);
    }

    public Jogo(String nome, String descricao, int numeroMinimoJogadores, int numeroMaximoJogadores, int idadeMinima, int duracaoMinima, int duracaoMaxima, int anoLancamento, String editora) {
        this.id = UUID.randomUUID();
        setNome(nome);
        setDescricao(descricao);
        setNumeroMinimoJogadores(numeroMinimoJogadores);
        setNumeroMaximoJogadores(numeroMaximoJogadores);
        setIdadeMinima(idadeMinima);
        setDuracaoMinima(duracaoMinima);
        setDuracaoMaxima(duracaoMaxima);
        setAnoLancamento(anoLancamento);
        setEditora(editora);
        this.dataCadastro = LocalDateTime.now();
        this.ativo = true;
    }

    //region GETTERS

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getNumeroMinimoJogadores() {
        return numeroMinimoJogadores;
    }

    public int getNumeroMaximoJogadores() {
        return numeroMaximoJogadores;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public int getDuracaoMinima() {
        return duracaoMinima;
    }

    public int getDuracaoMaxima() {
        return duracaoMaxima;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getEditora() {
        return editora;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }


    //endregion

    //region SETTERS

    public void setNome(String nome) {
        this.nome = Validar.validarNome(nome);
    }

    public void setDescricao(String descricao) {
        this.descricao = Validar.validarDescricao(descricao);
    }

    public void setNumeroMinimoJogadores(int numeroMinimoJogadores) {
        this.numeroMinimoJogadores = numeroMinimoJogadores;
    }

    public void setNumeroMaximoJogadores(int numeroMaximoJogadores) {
        this.numeroMaximoJogadores = numeroMaximoJogadores;
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public void setDuracaoMinima(int duracaoMinima) {
        this.duracaoMinima = duracaoMinima;
    }

    public void setDuracaoMaxima(int duracaoMaxima) {
        this.duracaoMaxima = duracaoMaxima;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setEditora(String editora) {
        this.editora = Validar.validarNomeMarcaOpcional(editora);
    }
    //endregion
}
