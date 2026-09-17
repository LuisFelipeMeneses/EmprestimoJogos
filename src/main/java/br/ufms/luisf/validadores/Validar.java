package br.ufms.luisf.validadores;

import java.time.LocalDateTime;

public class Validar {

    public static String validarNome(String nome) {
        return new ValidadorString(nome)
                .validarTamanho(3, 100)
                .validarPorRegex("^[A-Za-zÀ-ÖØ-öø-ÿ]+(?:[ '-][A-Za-zÀ-ÖØ-öø-ÿ]+)*$")
                .get();
    }

    public static String validarDescricao(String descricao) {
        return new ValidadorString(descricao)
                .validarTamanho(3, 500)
                .validarPorRegex("^[A-Za-zÀ-ÖØ-öø-ÿ0-9\\s\\.,!?;:-]+$")
                .get();
    }

    public static String validarDescricaoOpcional(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            return null;
        }
        return validarDescricao(descricao);
    }

    public static String validarEmail(String email) {
        return new ValidadorString(email)
                .validarTamanho(3, 100)
                .validarPorRegex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
                .get();
    }

    public static String validarTelefone(String telefone) {
        return new ValidadorString(telefone, v -> v.trim().replaceAll("[()-]", "").replaceAll("\\s+", " "))
                .validarNaoVazio()
                .validarPorRegex("^\\+55 \\d{2} 9\\d{8}$")
                .get();
    }

    public static String validarTelefoneOpcional(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            return null;
        }
        return validarTelefone(telefone);
    }

    public static String validarCodigo(String codigo) {
        return new ValidadorString(codigo)
                .validarTamanho(3,20)
                .get();
    }

    public static String validarNomeMarca(String nome) {
        return new ValidadorString(nome)
                .validarTamanho(2,50)
                .get();
    }

    public static String validarNomeMarcaOpcional(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }
        return validarNomeMarca(nome);
    }

    public static LocalDateTime validarDataHoraAntesDe(LocalDateTime data, LocalDateTime antes) {
        return new ValidadorDataHora(data).validarAntesDe(antes).get();
    }

    public static LocalDateTime validarDataHoraDepoisDe(LocalDateTime data, LocalDateTime depois) {
        return new ValidadorDataHora(data).validarDepoisDe(depois).get();
    }

    public static LocalDateTime validarDataHoraEntre(LocalDateTime data, LocalDateTime inicio, LocalDateTime fim) {
        return new ValidadorDataHora(data).validarAntesDe(fim).validarDepoisDe(inicio).get();
    }


}
