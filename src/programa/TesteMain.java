package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.servico.TipoToken;
import model.servico.Token;
import model.servico.Parser;


public class TesteMain {
    public static void main(String[] args) {
        // Exemplo de expressão que será analisada pelo analisador léxico e sintático
        String expressao = "c = v1 && v2 && a + 2 && 12.5";

        // Gera a lista de tokens a partir da expressão (simula o analisador léxico)
        List<Token> tokens = gerarTokens(expressao);

        // Cria o analisador sintático (parser) com a lista de tokens gerada
        Parser parser = new Parser(tokens);

        try {
            // Executa a análise sintática para verificar se a expressão está correta
            parser.analisar();
            System.out.println("Expressão sintaticamente correta!");
        } catch (RuntimeException e) {
            // Trata os erros sintáticos que podem ocorrer durante a análise
            System.out.println("Erro sintático: " + e.getMessage());
        }
    }

    /**
     * Função que simula a geração de tokens a partir de uma expressão (analisador léxico simples).
     * Divide a expressão em partes e cria tokens correspondentes a cada elemento.
     *
     * @param expressao A expressão de entrada que será analisada.
     * @return Uma lista de tokens gerados.
     */
    public static List<Token> gerarTokens(String expressao) {
        List<Token> tokens = new ArrayList<>();  // Cria uma lista para armazenar os tokens gerados.

        // Define a expressão regular para identificar os tokens
        String regex = "\\d+(\\.\\d+)?|&&|\\+|\\-|\\*|\\/|=|[a-zA-Z_][a-zA-Z0-9_]*|\\s+|!=|[!@#$%()]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expressao);

        // Varre a expressão para encontrar e processar os token
        while (matcher.find()) {
            String tokenStr = matcher.group().trim();  // remove espaços em branco

            if (tokenStr.isEmpty()) {
                continue;  // Ignora espaços em branco
            }

            if (tokenStr.matches("[!@#$%()]") || tokenStr.equals("!=")) {
                throw new RuntimeException("Erro sintático: Caractere especial não permitido: " + tokenStr);
            }

            // Identifica o isAdmin de token
            switch (tokenStr) {
                case "&&":
                    tokens.add(new Token(TipoToken.AND, tokenStr));
                    break;
                case "+":
                    tokens.add(new Token(TipoToken.PLUS, tokenStr));
                    break;
                case "-":
                    tokens.add(new Token(TipoToken.MINUS, tokenStr));
                    break;
                case "*":
                    tokens.add(new Token(TipoToken.MULT, tokenStr));
                    break;
                case "/":
                    tokens.add(new Token(TipoToken.DIV, tokenStr));
                    break;
                case "=":
                    tokens.add(new Token(TipoToken.ASSIGN, tokenStr));
                    break;
                default:
                    if (tokenStr.matches("\\d+")) {
                        tokens.add(new Token(TipoToken.NUM, tokenStr));  // Inteiro
                    } else if (tokenStr.matches("\\d+\\.\\d+")) {
                        tokens.add(new Token(TipoToken.REAL, tokenStr));  // Número real
                    } else if (tokenStr.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                        tokens.add(new Token(TipoToken.ID, tokenStr));  // Identificadores (variáveis)
                    } else {
                        throw new RuntimeException("Token desconhecido: " + tokenStr);
                    }
            }
        }

        // Adiciona o token EOF no final
        tokens.add(new Token(TipoToken.EOF, ""));
        return tokens;
    }
}
