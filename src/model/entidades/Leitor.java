package model.entidades;

import model.exception.EmprestimoLimiteExcedidoException;
import model.servico.Emprestimo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Leitor extends Usuario {
    private List<Emprestimo> historicoEmprestimo;
    private int maxEmprestimos;

    public Leitor(String nome, String email, String senha, int maxEmprestimos) {
        super(nome, email, senha, false);
        this.maxEmprestimos = maxEmprestimos;
        this.historicoEmprestimo = new ArrayList<>();
    }
 
    public List<Emprestimo> getHistoricoEmprestimo() {
        return historicoEmprestimo;
    }

    public void adicionarHistoricoEmprestimo(Emprestimo emprestimo) throws EmprestimoLimiteExcedidoException {
        if (historicoEmprestimo.size() < maxEmprestimos) {
            historicoEmprestimo.add(emprestimo);
        } else {
            throw new EmprestimoLimiteExcedidoException("Limite de empréstimos atingido!");
        }
    }
    
    public void devolverLivroHistoricoEmprestimo(Emprestimo emprestimo) {
        if (historicoEmprestimo.contains(emprestimo)) {
            historicoEmprestimo.remove(emprestimo);
        } else {
            throw new IllegalArgumentException("Empréstimo não encontrado!");
        }
    }

    public void exibirHistoricoEmprestimo() {
        if (historicoEmprestimo.isEmpty()) {
            System.out.println("Histórico de empréstimos vazio!");
        } else {
            for (Emprestimo emprestimo : historicoEmprestimo) {
                System.out.println(emprestimo.toString());
            }
        }
    }
    
    public static void validaDataEntrega(LocalDate  dataEntrega) {

 		LocalDate dataAtual = LocalDate.now();

 		long diferencaDias = ChronoUnit.DAYS.between(dataAtual, dataEntrega);

 		if (Math.abs(diferencaDias) == 1) {
 			System.out.println("\u001B[31m" + "Atenção: A data de devolução está próxima!" + "\u001B[0m");
 		
 		
 	     }
      }
}
