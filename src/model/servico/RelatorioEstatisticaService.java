package model.servico;

import model.entidades.Livro;

import java.util.List;

public class RelatorioEstatisticaService {
    private EmprestimoService emprestimoService;
    private List<Livro> livros;

    public RelatorioEstatisticaService(EmprestimoService emprestimoService, List<Livro> livros) {
        this.emprestimoService = emprestimoService;
        this.livros = livros;
    }

    public void relatorioLivrosMaisEmprestados() {
        int[] emprestimosPorLivro = new int[livros.size()];

        for (Emprestimo emprestimo : emprestimoService.getEmprestimos()) {
            Livro livro = emprestimo.getLivro();
            int index = livros.indexOf(livro);
            if (index >= 0) {
                emprestimosPorLivro[index]++;
            }
        }

        for (int i = 0; i < emprestimosPorLivro.length; i++) {
            for (int j = i + 1; j < emprestimosPorLivro.length; j++) {
                if (emprestimosPorLivro[j] > emprestimosPorLivro[i]) {
                    // Trocar os valores de contagem
                    int tempCount = emprestimosPorLivro[i];
                    emprestimosPorLivro[i] = emprestimosPorLivro[j];
                    emprestimosPorLivro[j] = tempCount;
                    
                    // Trocar os livros correspondentes
                    Livro tempLivro = livros.get(i);
                    livros.set(i, livros.get(j));
                    livros.set(j, tempLivro);
                }
            }
        }

        for (int i = 0; i < livros.size(); i++) {
            System.out.println("Livro: " + livros.get(i).getTitulo() + " | Emprestado: " + emprestimosPorLivro[i] + " vezes");
        }
    }

    public void estatisticasBiblioteca() {
        int totalEmprestimos = emprestimoService.getEmprestimos().size();
        int livrosDisponiveis = 0;

        for (Livro livro : livros) {
            if (livro.getNumeroEmprestimos() == 0) {
                livrosDisponiveis++;
            }
        }

        System.out.println("Estatísticas da Biblioteca:");
        System.out.println("Total de Empréstimos: " + totalEmprestimos);
        System.out.println("Livros Disponíveis: " + livrosDisponiveis);
        System.out.println("Total de Livros: " + livros.size());
    }
}

