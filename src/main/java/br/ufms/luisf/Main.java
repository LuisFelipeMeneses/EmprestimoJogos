package br.ufms.luisf;

import br.ufms.luisf.entities.categoria.Categoria;
import br.ufms.luisf.entities.emprestimo.Emprestimo;
import br.ufms.luisf.entities.exemplar.EstadoConservacaoJogo;
import br.ufms.luisf.entities.exemplar.ExemplarJogo;
import br.ufms.luisf.entities.item_emprestimo.ItemEmprestimo;
import br.ufms.luisf.entities.jogo.Jogo;
import br.ufms.luisf.entities.reserva.Reserva;
import br.ufms.luisf.entities.usuario.Usuario;

import java.time.LocalDateTime;

public class Main {
    static void main(String[] args) {
        Jogo jogo1 = new Jogo(
                "Jogo de tabuleiro 1",
                "Descrição do jogo de tabuleiro 1",
                1,
                4,
                0,
                15,
                60,
                2000,
                "Editora 1"
                );
        Categoria categoria1 = new Categoria("Categoria 1", "Descrição da categoria 1");
        jogo1.adicionarCategoria(categoria1);
        Usuario usuario1 = new Usuario("Usuário Um", "email1@exemplo.com");
        Reserva reserva1 = new Reserva(jogo1.getId(), usuario1.getId());
        ExemplarJogo exemplarJogo1 = new ExemplarJogo("JOG-1", jogo1.getId(), EstadoConservacaoJogo.BOM, "Observação importante");
        jogo1.adicionarExemplar(exemplarJogo1);
        ItemEmprestimo itemEmprestimo1 = new ItemEmprestimo(jogo1.getId(), exemplarJogo1.getId());
        Emprestimo emprestimo1 = new Emprestimo(usuario1.getId(), LocalDateTime.of(2023, 1, 1, 12, 0), "Uma Observação relevante");
        emprestimo1.adicionarItem(itemEmprestimo1);
        jogo1.adicionarReserva(reserva1);
        usuario1.adicionarEmprestimo(emprestimo1);
        usuario1.adicionarReserva(reserva1);


    }
}
