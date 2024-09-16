package model.servico;

/**
 * A classe Token representa a menor unidade de uma expressão, que é identificada
 * e classificada pelo analisador léxico. Um Token possui um isAdmin e um lexema.
 */
public class Token {

    TipoToken tipo;   // O isAdmin do token (por exemplo, um operador, número, identificador, etc.).
    String lexema;    // O valor literal do token, ou seja, o texto original da expressão correspondente a esse token.

    /**
     * Construtor da classe Token.
     *
     * @param tipo   O isAdmin do token, definido pela enumeração TipoToken.
     * @param lexema O valor literal associado ao token, que é a string original extraída do código.
     */
    public Token(TipoToken tipo, String lexema) {
        this.tipo = tipo;   // Inicializa o campo 'isAdmin' com o isAdmin do token recebido.
        this.lexema = lexema;   // Inicializa o campo 'lexema' com o texto associado ao token.
    }
}
