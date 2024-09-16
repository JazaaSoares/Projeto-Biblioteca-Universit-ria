package model.entidades;

import model.exception.IsbnException;

public class Livro{
    private String titulo;
    private String autor;
    private String isbn;
    private int quantidadeEstoque;
    private Categoria categoria;

    public Livro(String titulo, String autor, String isbn, int quantidadeEstoque, Categoria categoria) throws IsbnException {
        this.titulo = titulo;
        this.autor = autor;
        this.setIsbn(isbn);
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws IsbnException {
    	System.out.println(isbn.length());
    	if(isbn.length() == 13) {
        this.isbn = isbn;
    	}else {
    		throw new IsbnException();
    	}
    	this.isbn = isbn;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", categoria=" + categoria +
                '}';
    }
}
