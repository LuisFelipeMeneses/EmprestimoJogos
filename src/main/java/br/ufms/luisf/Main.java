package br.ufms.luisf;

import br.ufms.luisf.entities.categoria.Categoria;
import br.ufms.luisf.entities.emprestimo.Emprestimo;
import br.ufms.luisf.entities.exemplar.EstadoConservacaoJogo;
import br.ufms.luisf.entities.exemplar.ExemplarJogo;
import br.ufms.luisf.entities.jogo.Jogo;
import br.ufms.luisf.entities.reserva.Reserva;
import br.ufms.luisf.entities.usuario.Usuario;

import java.time.LocalDateTime;

public class Main {
    static void main(String[] args) {
        Jogo jogo1 = new Jogo(
                "Jogo de tabuleiro",
                "Descrição do jogo de tabuleiro",
                1,
                4,
                0,
                15,
                60,
                2000,
                "Editora"
                );
        Categoria categoria1 = new Categoria("Categoria", "Descrição da categoria");
        Usuario usuario1 = new Usuario("Usuário Um", "email1@exemplo.com");
        Reserva reserva1 = new Reserva(jogo1.getId(), usuario1.getId());
        ExemplarJogo exemplarJogo1 = new ExemplarJogo("JOG-1", jogo1.getId(), EstadoConservacaoJogo.BOM, "Observação importante");
        Emprestimo emprestimo1 = new Emprestimo(usuario1.getId(), LocalDateTime.of(2027, 1, 1, 12, 0), "Uma Observação relevante");

    }
}
