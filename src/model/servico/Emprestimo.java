package model.servico;

import java.time.LocalDate;

import model.entidades.Livro;

public class Emprestimo {
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean emAtraso;

    public Emprestimo(Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.emAtraso = false;
    }

    // Getters e Setters
    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isEmAtraso() {
        return emAtraso;
    }

    public void setEmAtraso(boolean emAtraso) {
        this.emAtraso = emAtraso;
    }

    @Override
    public String toString() {
        return "Livro emprestado: " + livro.getTitulo() + " | Data de Devolução: " + dataDevolucao;
    }
}


