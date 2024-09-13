package entidades;
import java.util.Scanner;

public class Biblioteca{
	private Livro[] livros;
	private int cont;
	
	public Biblioteca(int capacidade) {
		this.livros = new Livro[capacidade];
		this.cont = 0;
	}
	
	public void adicionarLivro(Livro livro) {
		if(cont<livros.length) {
			livros[cont] = livro;
			cont++;
		}else {
			System.out.println("Biblioteca cheia!");
		}
	}
	
	public void removerLivro(String isbn) {
		for(int i=0; i<cont; i++) {
			if(livros[i].getIsbn().equals(isbn)) {
				for(int j=i; j<cont-1; j++) {
					livros[j]=livros[j+1];
				}
				livros[cont-1] = null;
				cont--;
				return;
			}
		}
		System.out.println("ISBN" + isbn + "não encontrado!");
	}
	
	public void editarLivro() {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ISBN do livro que deseja editar: ");
        String isbn = scanner.nextLine();

        for (int i = 0; i < cont; i++) {
            if (livros[i].getIsbn().equals(isbn)) {
                System.out.println("Livro encontrado:");
                System.out.println(livros[i]);

                System.out.print("Digite o novo título: ");
                String novoTitulo = scanner.nextLine();

                System.out.print("Digite o novo autor: ");
                String novoAutor = scanner.nextLine();

                System.out.print("Digite a nova quantidade em estoque: ");
                int novaQuantidade = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Digite a nova categoria: ");

                livros[i].setTitulo(novoTitulo);
                livros[i].setAutor(novoAutor);
                livros[i].setQuantidadeEstoque(novaQuantidade);
                livros[i].setCategoria(Categoria.CALCULO);
                livros[i].setCategoria("teste");

                System.out.println("Livro editado com sucesso!");
                return;
            }
        }
        System.out.println("Livro com ISBN " + isbn + " não encontrado.");
	}
	
	public void buscarPorTitulo(String titulo) {
		boolean encontrado = false;
		for(int i=0; i<cont;i++) {
			if(livros[i].getTitulo().equals(titulo)) {
				System.out.println(livros[i]);
				encontrado = true;
			}
		}
		
		if(encontrado == false) {
			System.out.println("Nenhum livro encontrado com esse titulo!");
		}
	}
	
	public void buscarPorAutor(String autor) {
		boolean encontrado = true;
		for(int i=0; i<cont; i++) {
			if(livros[i].getAutor().equals(autor)) {
				System.out.println(livros[i]);
				encontrado = true;
			}
		}
		
		if(encontrado == false) {
			System.out.println("Nenhum livro encontrado com esse autor!");
		}
	}
	
	public void buscarPorCategoria(String categoria) {
		boolean encontrado = false;
		for(int i=0;i<cont;i++) {
			if(livros[i].getCategoria().equals(categoria)) {
				System.out.println(categoria);
				encontrado = true;
			}
		}
		if(encontrado==false) {
			System.out.println("Nenhum livro encontrado com essa categoria!");
		}
	}
	
	public void listarLivros() {
		if(cont == 0) {
			System.out.println("Nenhum livro cadastrado!!");
			return;
		}
		for( int i=0; i<cont; i++) {
			System.out.println(livros[i]);
		}
	}
	
	
}
