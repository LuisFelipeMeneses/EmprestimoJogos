package br.ufms.luisf.validadores;

import java.time.LocalDateTime;

public class ValidadorDataHora extends Validador<LocalDateTime, ValidadorDataHora>{

    public ValidadorDataHora(LocalDateTime data) {
        super(data);
    }

    public ValidadorDataHora validarDepoisDe(LocalDateTime data) {
        if (this.valor.isAfter(data)) {
            return this;
        } else {
            throw new IllegalArgumentException("Data deve ser posterior a " + data);
        }
    }

    public ValidadorDataHora validarAntesDe(LocalDateTime data) {
        if (this.valor.isBefore(data)) {
            return this;
        } else {
            throw new IllegalArgumentException("Data deve ser anterior a " + data);
        }
    }
}