package model.servico;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import model.entidades.Livro;
import model.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;


public class EmprestimoService {
	private List<Emprestimo> emprestimos;

	public EmprestimoService() {
		this.emprestimos = new ArrayList<>();
	}

	public void realizarEmprestimo(Usuario usuario, Livro livro) {
		LocalDate hoje = LocalDate.now();
		LocalDate dataDevolucao = hoje.plusDays(14);
		Emprestimo emprestimo = new Emprestimo(livro, hoje, dataDevolucao);
		emprestimos.add(emprestimo);
		System.out.println("Livro " + livro.getTitulo() + " emprestado a " + usuario.getNome());
	}
	
	public static void validaDataEntrega(LocalDate  dataDevolucao) {
		LocalDate dataAtual = LocalDate.now();
		long diferencaDias = ChronoUnit.DAYS.between(dataAtual, dataDevolucao);
		if (Math.abs(diferencaDias) == 1) {
			System.out.println("\u001B[31m" + "Atenção: A data de devolução está próxima!" + "\u001B[0m");
	     }
     }
	
	public void devolverLivro(Emprestimo emprestimo) {
		emprestimos.remove(emprestimo);
		System.out.println("Livro devolvido: " + emprestimo.getLivro().getTitulo());
	}

	public List<Emprestimo> listarEmprestimos() {
		return emprestimos;
	}
}
