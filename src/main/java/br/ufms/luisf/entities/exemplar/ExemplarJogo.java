package br.ufms.luisf.entities.exemplar;

import br.ufms.luisf.validadores.Validar;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ExemplarJogo {
    private UUID id;
    private String codigo;
    private UUID jogoId;
    private LocalDateTime dataCadastro;
    private EstadoConservacaoJogo estadoConservacao;
    private StatusExemplar status;
    private String observacoes;

    public ExemplarJogo(UUID id, String codigo, UUID jogoId, LocalDateTime dataCadastro, EstadoConservacaoJogo estadoConservacao, StatusExemplar status, String observacoes) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.status = status;
        this(codigo, jogoId, estadoConservacao, observacoes);
    }

    public ExemplarJogo(String codigo, UUID jogoId, EstadoConservacaoJogo estadoConservacao) {
        this(codigo, jogoId, estadoConservacao, null);
    }

    public ExemplarJogo(String codigo, UUID jogoId, EstadoConservacaoJogo estadoConservacao, String observacoes) {
        this.id = UUID.randomUUID();
        setCodigo(codigo);
        this.jogoId = jogoId;
        this.dataCadastro = LocalDateTime.now();
        this.estadoConservacao = estadoConservacao;
        setStatus(StatusExemplar.DISPONIVEL);
        setObservacoes(observacoes);
    }

    //region GETTERS

    public UUID getId() {
        return id;
    }
    public String getCodigo() {
        return codigo;
    }
    public UUID getJogoId() {
        return jogoId;
    }
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    public EstadoConservacaoJogo getEstadoConservacao() {
        return estadoConservacao;
    }
    public StatusExemplar getStatus() {
        return status;
    }
    public String getObservacoes() {
        return observacoes;
    }
    //endregion

    //region SETTERS

    public void setCodigo(String codigo) {
        this.codigo = Validar.validarCodigo(codigo);
    }

    public void setEstadoConservacao(EstadoConservacaoJogo estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public void setStatus(StatusExemplar status) {
        this.status = status;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = Validar.validarDescricaoOpcional(observacoes);
    }
    //endregion
}
