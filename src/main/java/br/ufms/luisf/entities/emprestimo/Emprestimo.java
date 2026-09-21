package br.ufms.luisf.entities.emprestimo;

import br.ufms.luisf.validadores.Validar;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Emprestimo {
    private UUID id;
    private UUID usuarioId;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataPrevistaDevolucao;
    private LocalDateTime dataDevolucao;
    private StatusEmprestimo status;
    private String observacoes;

    public Emprestimo(UUID id, UUID usuarioId, LocalDateTime dataEmprestimo, LocalDateTime dataPrevistaDevolucao, LocalDateTime dataDevolucao, StatusEmprestimo status, String observacoes) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this(usuarioId, dataPrevistaDevolucao, observacoes);
    }

    public Emprestimo(UUID usuarioId, LocalDateTime dataPrevistaDevolucao) {
        this(usuarioId, dataPrevistaDevolucao, null);
    }

    public Emprestimo(UUID usuarioId, LocalDateTime dataPrevistaDevolucao, String observacoes) {
        this.id = UUID.randomUUID();
        this.usuarioId = usuarioId;
        this.dataEmprestimo = LocalDateTime.now();
        setDataPrevistaDevolucao(dataPrevistaDevolucao);
        setStatus(StatusEmprestimo.ATIVO);
        setObservacoes(observacoes);
    }

    //region GETTERS
    public UUID getId() {
        return id;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDateTime getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public String getObservacoes() {
        return observacoes;
    }
    //endregion

    //region SETTERS
    public void setStatus(StatusEmprestimo status) {
        this.status = status;
    }

    public void setDataPrevistaDevolucao(LocalDateTime dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = Validar.validarDataHoraDepoisDe(dataPrevistaDevolucao, this.dataEmprestimo);
        if (dataPrevistaDevolucao.isBefore(LocalDateTime.now())) {
            setStatus(StatusEmprestimo.ATRASADO);
        }
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        if(this.dataDevolucao == null) {
            this.dataDevolucao = Validar.validarDataHoraDepoisDe(dataDevolucao, this.dataEmprestimo);
        } else {
            throw new IllegalStateException("Data de devolução já está definida.");
        }
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = Validar.validarDescricaoOpcional(observacoes);
    }
    //endregion
}
