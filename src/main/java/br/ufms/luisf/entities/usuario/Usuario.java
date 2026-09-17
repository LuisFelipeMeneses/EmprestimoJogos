package br.ufms.luisf.entities.usuario;

import br.ufms.luisf.entities.emprestimo.Emprestimo;
import br.ufms.luisf.entities.reserva.Reserva;
import br.ufms.luisf.validadores.Validar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario {
    UUID id;
    String nome;
    String email;
    String telefone;
    LocalDateTime dataCadastro;
    StatusUsuario status;

    List<Emprestimo> emprestimos;
    List<Reserva> reservas;

    public Usuario(String nome, String email, String telefone) {
        this.id = UUID.randomUUID();
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
        this.dataCadastro = LocalDateTime.now();
        setStatus(StatusUsuario.ATIVO);

        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
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

    public List<Reserva> getReservas() {
        return List.copyOf(reservas);
    }

    public List<Emprestimo> getEmprestimos() {
        return List.copyOf(emprestimos);
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

    public boolean adicionarEmprestimo(Emprestimo emprestimo) {
        if (emprestimo == null) {
            throw new IllegalArgumentException("Empréstimo não pode ser nulo");
        }
        return emprestimos.add(emprestimo);
    }

    public boolean removerEmprestimo(Emprestimo emprestimo) {
        return emprestimos.remove(emprestimo);
    }

    public boolean adicionarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva não pode ser nula");
        }
        return reservas.add(reserva);
    }

    public boolean removerReserva(Reserva reserva) {
        return reservas.remove(reserva);
    }
}
