package br.ufms.luisf.entities.reserva;

import br.ufms.luisf.entities.emprestimo.Emprestimo;
import br.ufms.luisf.validadores.Validar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Reserva {
    UUID id;
    UUID usuarioId;
    UUID jogoId;
    LocalDateTime dataReserva;
    StatusReserva status;
    LocalDateTime dataAtendimento;
    LocalDateTime dataCancelamento;
    String observacoes;

    public Reserva(UUID usuarioId, UUID jogoId) {
        this(usuarioId, jogoId, null);
    }

    public Reserva(UUID usuarioId, UUID jogoId, String observacoes) {
        this.id = UUID.randomUUID();
        this.usuarioId = usuarioId;
        this.jogoId = jogoId;
        this.dataReserva = LocalDateTime.now();
        setStatus(StatusReserva.ATIVA);
        setObservacoes(observacoes);
    }

    //region GETTERS

    public UUID getId() {
        return id;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public UUID getJogoId() {
        return jogoId;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public LocalDateTime getDataCancelamento() {
        return dataCancelamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    //endregion

    //region SETTERS

    public void setObservacoes(String observacoes) {
        this.observacoes = Validar.validarDescricaoOpcional(observacoes);
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = Validar.validarDataHoraDepoisDe(dataAtendimento,dataReserva);
    }

    public void setDataCancelamento(LocalDateTime dataCancelamento) {
        this.dataCancelamento = Validar.validarDataHoraDepoisDe(dataCancelamento,dataReserva);
    }

    //endregion
}
