package br.ufms.luisf.entities.categoria;

import br.ufms.luisf.validadores.Validar;

import java.util.UUID;

public class Categoria {
    UUID id;
    String nome;
    String descricao;

    public Categoria(String nome) {
        this(nome, null);
    }

    public Categoria(String nome, String descricao) {
        this.id = UUID.randomUUID();
        setNome(nome);
        setDescricao(descricao);
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
    //endregion

    //region SETTERS

    public void setNome(String nome) {
        this.nome = Validar.validarNome(nome);
    }

    public void setDescricao(String descricao) {
        this.descricao = Validar.validarDescricaoOpcional(descricao);
    }
    //endregion
}
