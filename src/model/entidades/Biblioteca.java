package model.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros;
    private int cont;

    public Biblioteca() {
        this.livros = new ArrayList<>(); 
        this.cont = 0;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro); 
        cont++;
        System.out.println("Livro adicionado com sucesso!");
    }

    public void removerLivro(String isbn) {
        for (int i = 0; i < cont; i++) {
            if (livros.get(i).getIsbn().equals(isbn)) {
                livros.remove(i);
                cont--;
                System.out.println("Livro com ISBN " + isbn + " removido com sucesso!");
                return;
            }
        }
        System.out.println("ISBN " + isbn + " não encontrado!");
    }

    public void editarLivro() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ISBN do livro que deseja editar: ");
        String isbn = sc.nextLine();

        for (int i = 0; i < cont; i++) {
            if (livros.get(i).getIsbn().equals(isbn)) {
                System.out.println("Livro encontrado:");
                System.out.println(livros.get(i));

                System.out.print("Digite o novo título: ");
                String novoTitulo = sc.nextLine();

                System.out.print("Digite o novo autor: ");
                String novoAutor = sc.nextLine();

                System.out.print("Digite a nova quantidade em estoque: ");
                int novaQuantidade = sc.nextInt();
                sc.nextLine();

                System.out.print("Digite a nova categoria: ");
                String novaCategoriaStr = sc.nextLine();
                Categoria novaCategoria;

                try {
                    novaCategoria = Categoria.valueOf(novaCategoriaStr.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Categoria inválida. Livro não editado.");
                    return;
                }

                livros.get(i).setTitulo(novoTitulo);
                livros.get(i).setAutor(novoAutor);
                livros.get(i).setQuantidadeEstoque(novaQuantidade);
                livros.get(i).setCategoria(novaCategoria);

                System.out.println("Livro editado com sucesso!");
                return;
            }
        }
        System.out.println("Livro com ISBN " + isbn + " não encontrado.");
    }

    public boolean buscarPorTitulo(String titulo) {
        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(livro);
                encontrado = true;
            }
        }

        if (encontrado==false) {
            System.out.println("Nenhum livro encontrado com esse título!");
        }
        
        return encontrado;
    }

    public boolean buscarPorAutor(String autor) {
        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println(livro);
                encontrado = true;
            }
        }

        if (encontrado==false) {
            System.out.println("Nenhum livro encontrado com esse autor!");
        }
        
        return encontrado;
    }

    public boolean buscarPorCategoria(String categoriaStr) {
        boolean encontrado = false;
        Categoria categoria;
        try {
            // Tenta converter a string para o enum Categoria
            categoria = Categoria.valueOf(categoriaStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Categoria inválida.");
            return encontrado; // Sai do método se a categoria não for válida
        }
        for (Livro livro : livros) {
            if (livro.getCategoria() == categoria) {
                System.out.println(livro);
                encontrado = true;
            }
        }
        if (encontrado==false) {
            System.out.println("Nenhum livro encontrado com essa categoria!");
        }
        
        return encontrado;
    }

    public boolean buscarPorIsbn(String isbn) {
        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                System.out.println(livro);
                encontrado = true;
            }
        }
        if (encontrado==false) {
            System.out.println("Nenhum ISBN encontrado com esse valor!");
        }
        
        return encontrado;
    }

    public void filtrarLivros(String criterio) {
        Scanner sc = new Scanner(System.in);
        boolean encontrado = false;
       
            switch (criterio.toLowerCase()) {
                case "titulo":
                    System.out.println("Insira o título do livro: ");
                    String titulo = sc.nextLine();
                    encontrado = buscarPorTitulo(titulo);
                    break;
                case "autor":
                    System.out.println("Insira o nome do autor: ");
                    String autor = sc.nextLine();
                    encontrado = buscarPorAutor(autor);
                    break;
                case "categoria":
                    System.out.println("Insira a categoria: ");
                    String categoria = sc.nextLine();
                    encontrado = buscarPorCategoria(categoria);
                    break;
                case "isbn":
                    System.out.println("Insira o ISBN: ");
                    String isbn = sc.nextLine();
                    encontrado = buscarPorIsbn(isbn);
                    break;
                default:
                    System.out.println("Critério de filtragem inválido.");
                    return;
            }
        
        if (encontrado == false) {
            System.out.println("Nenhum livro encontrado com o critério: " + criterio);
        }
    }
    
    

    public void listarLivros() {
        if (cont == 0) {
            System.out.println("Nenhum livro cadastrado!!");
            return;
        }
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}