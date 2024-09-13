package programa;

import entidades.Biblioteca;
import entidades.Categoria;
import entidades.Livro;
import entidades.CustomException;
import java.util.Scanner;

public class TesteMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca(10); // Capacidade para 10 livros

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    // Solicitar informações do livro
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ISBN do livro: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Digite a quantidade em estoque: ");
                    int quantidadeEstoque = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite a categoria do livro ( FICCAO,\r\n"
                    		+ "	   1- CALCULO,\r\n"
                    		+ "	   2- ALGEBRA,\r\n"
                    		+ "	   3- ENGENHARIA,\r\n"
                    		+ "	   4- LITERATURA,\r\n"
                    		+ "    5- TECNOLOGIA_DA_INFORMACAO: ");
                    String categoriaStr = scanner.nextLine();
                    Categoria categoria;

                    try {
                        categoria = Categoria.valueOf(categoriaStr.toUpperCase()); //valueOf - atribui a string a categoria | toUpperCase - transforma toda s string em maiuscula
                    } catch (IllegalArgumentException e) {
                        System.out.println("Categoria inválida. Livro não adicionado.");
                        continue;
                    }
                    try {
                        Livro livro = new Livro(titulo, autor, isbn, quantidadeEstoque, categoria);
                        biblioteca.adicionarLivro(livro);
                    } catch (CustomException e) {
                        System.out.println("Erro ao adicionar livro: " + e.getMessage());
                    }
                    break;

                    Livro livro = new Livro(titulo, autor, isbn, quantidadeEstoque, categoria);
                    biblioteca.adicionarLivro(livro);
                    break;

                case 2:
                    // Listar livros
                    System.out.println("Livros na biblioteca:");
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
