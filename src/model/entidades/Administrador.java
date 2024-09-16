package model.entidades;

public class Administrador extends Usuario {
    private Biblioteca biblioteca;

    public Administrador(String nome, String email, String senha, Biblioteca biblioteca) {
        super(nome, email, senha, true);
        this.biblioteca = biblioteca;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void adicionarLivro(Livro livro) {
        biblioteca.adicionarLivro(livro); // Usa o método da classe Biblioteca
    }

    /*public void adicionarUsuario(Usuario usuario) {
        if (biblioteca.getUsuarios().size() < biblioteca.getMaxUsuarios()) {
            biblioteca.getUsuarios().add(usuario);
        } else {
            throw new RuntimeException("Limite de usuários atingido!");
        }
    }*/

    public void removerLivro(Livro livro) {
        biblioteca.removerLivro(livro.getIsbn()); // Usa o método da classe Biblioteca
    }

    //Admin
//    public void adicionarCategoriaLivro(String categoria) {
//        int contCategoria = 0;
//
//        for(String categoriaAux : biblioteca.getCategorias()) {
//            if (contCategoria == biblioteca.getLivros().size()) {
//                livro.setCategoria(categoria);
//                break;
//            }
//
//            contCategoria++;
//        }
//    }
}

