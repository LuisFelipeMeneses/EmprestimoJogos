package br.ufms.luisf.entities.usuario;

import br.ufms.luisf.entities.emprestimo.Emprestimo;
import br.ufms.luisf.entities.reserva.Reserva;
import br.ufms.luisf.validadores.Validar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario {
    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
    private StatusUsuario status;

    public Usuario(UUID id, String nome, String email, String telefone, LocalDateTime dataCadastro, StatusUsuario status) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.status = status;

        this(nome, email, telefone);
    }

    public Usuario(String nome, String email, String telefone) {
        this.id = UUID.randomUUID();
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
        this.dataCadastro = LocalDateTime.now();
        setStatus(StatusUsuario.ATIVO);

    }

    public Usuario(String nome, String email) {
        this(nome, email, null);
    }

    //region Getters

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public StatusUsuario getStatus() {
        return status;
    }

    //endregion

    //region Setters
    public void setNome(String nome) {
        this.nome = Validar.validarNome(nome);
    }

    public void setEmail(String email) {
        this.email = Validar.validarEmail(email);
    }

    public void setTelefone(String telefone) {
        this.telefone = Validar.validarTelefoneOpcional(telefone);
    }

    public void setStatus(StatusUsuario status) {
        this.status = status;
    }
    //endregion
}
