package br.ufms.luisf.validadores;

import java.util.function.Function;

public class ValidadorString extends Validador<String, ValidadorString> {
    public ValidadorString(String valor) {
        this(valor, String::trim);
    }

    public ValidadorString(String valor, Function<String, String> normalizer) {
        super(normalizer.apply(valor));
    }

    public ValidadorString validarTamanho(int tamanho) {
        validarTamanho(tamanho, tamanho);
        return this;
    }

    public ValidadorString validarTamanho(int min, int max) {
        if (valor.length() < min || valor.length() > max) {
            throw new IllegalArgumentException("Tamanho inválido");
        }
        return this;
    }

    public ValidadorString validarPorRegex(String regex) {
        if (!valor.matches(regex)) {
            throw new IllegalArgumentException("Formato inválido");
        }
        return this;
    }

    public ValidadorString validarNaoVazio() {
        if (valor == null || valor.isEmpty()) {
            throw new IllegalArgumentException("Valor não pode ser vazio");
        }
        return this;
    }
}
