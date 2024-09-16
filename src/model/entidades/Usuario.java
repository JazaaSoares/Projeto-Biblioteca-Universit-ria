package model.entidades;

import model.exception.UsuarioNaoAutenticadoException;

public abstract class Usuario {
    private String nome;
    private String email;
    private String senha;
    private boolean isAdmin;

    public Usuario(String nome, String email, String senha, boolean isAdmin) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAdmin = isAdmin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
    
    
    public boolean login(String email, String senha) throws UsuarioNaoAutenticadoException {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            return true;
        } else {
            throw new UsuarioNaoAutenticadoException("E-mail ou senha inválidos!");
        }
    }
}

