package br.ufms.luisf.entities.item_emprestimo;

import java.util.UUID;

public class ItemEmprestimo {
    UUID id;
    UUID emprestimoId;
    UUID exemplarId;

    public ItemEmprestimo(UUID emprestimoId, UUID exemplarId) {
        this.id = UUID.randomUUID();
        this.emprestimoId = emprestimoId;
        this.exemplarId = exemplarId;
    }

    //region GETTERS
    public UUID getId() {
        return id;
    }

    public UUID getEmprestimoId() {
        return emprestimoId;
    }

    public UUID getExemplarId() {
        return exemplarId;
    }
    //endregion
}
