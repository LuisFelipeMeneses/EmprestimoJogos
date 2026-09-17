package br.ufms.luisf.validadores;

import java.util.function.Consumer;
import java.util.function.Function;

public class Validador<T, S extends Validador<T, S>> {
    protected T valor;

    public Validador(T valor) {
        this.valor = valor;
    }

    public T get() {
        return valor;
    }

    // TODO: fazer funcionar
    public S validarOpcional(T valor, Function<T, S> validador) {
        if (validador == null) {
            return null;
        }
        return validador.apply(valor);
    }

}
