package model.servico;

import java.util.List;

/**
 * A classe Parser é responsável pela análise sintática de uma lista de tokens gerada
 * pelo analisador léxico. Ela verifica se os tokens seguem as regras da gramática
 * para uma determinada linguagem ou expressão.
 */
public class Parser {
    private Token tokenAtual;  // O token atual que está sendo analisado.
    private List<Token> tokens;  // A lista de tokens gerada pelo analisador léxico.
    private int pos = 0;  // A posição atual na lista de tokens.

    /**
     * Construtor do Parser.
     * Inicializa a lista de tokens e configura o tokenAtual como o primeiro token da lista.
     *
     * @param tokens A lista de tokens a ser analisada.
     */
    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.tokenAtual = tokens.get(pos);  // Define o tokenAtual como o primeiro token da lista.
    }

    /**
     * Método principal de análise sintática.
     * Inicia a análise verificando uma atribuição e, ao final, verifica se todos os tokens
     * foram consumidos corretamente até o final da expressão (EOF).
     */
    public void analisar() {
        atribuicao();  // Inicia verificando se há uma atribuição válida.
        if (tokenAtual.tipo != TipoToken.EOF) {  // Verifica se todos os tokens foram consumidos.
            throw new RuntimeException("Token inesperado: " + tokenAtual.lexema);  // Erro se há tokens não processados.
        }
    }

    /**
     * Método para analisar uma atribuição na forma: ID = Expressão.
     * Exige que o primeiro token seja um identificador (ID) e o segundo seja o símbolo
     * de atribuição ("="), seguido de uma expressão válida.
     */
    private void atribuicao() {
        if (tokenAtual.tipo == TipoToken.ID) {  // Verifica se o primeiro token é um identificador.
            consumir(TipoToken.ID);  // Consome o identificador.
            if (tokenAtual.tipo == TipoToken.ASSIGN) {  // Verifica se o próximo token é o "=".
                consumir(TipoToken.ASSIGN);  // Consome o "=".
                expressao();  // Analisa a expressão à direita do "=".
            } else {
                throw new RuntimeException("Esperava '=', mas encontrou: " + tokenAtual.lexema);  // Erro se não houver "=".
            }
        } else {
            throw new RuntimeException("Esperava identificador no início da atribuição, mas encontrou: " + tokenAtual.lexema);  // Erro se o primeiro token não for um identificador.
        }
    }

    /**
     * Método para analisar uma expressão que pode ser composta por termos ligados pelo operador "&&".
     * A expressão segue a regra: Expressão → Termo (&& Termo)*.
     */
    private void expressao() {
        termo();  // Analisa o primeiro termo.
        while (tokenAtual.tipo == TipoToken.AND) {  // Enquanto houver operadores "&&".
            consumir(TipoToken.AND);  // Consome o "&&".
            termo();  // Analisa o próximo termo.
        }
    }

    /**
     * Método para analisar um termo, que pode ser uma operação de soma ou subtração entre fatores.
     * O termo segue a regra: Termo → Fator (+|- Fator)*.
     */
    private void termo() {
        fator();  // Analisa o primeiro fator.
        while (tokenAtual.tipo == TipoToken.PLUS || tokenAtual.tipo == TipoToken.MINUS) {  // Verifica se o próximo token é "+" ou "-".
            if (tokenAtual.tipo == TipoToken.PLUS) {
                consumir(TipoToken.PLUS);  // Consome o "+".
            } else {
                consumir(TipoToken.MINUS);  // Consome o "-".
            }
            fator();  // Analisa o próximo fator após o operador "+" ou "-".
        }
    }

    /**
     * Método para analisar um fator, que pode ser uma operação de multiplicação ou divisão entre valores.
     * O fator segue a regra: Fator → Valor (*|/ Valor)*.
     */
    private void fator() {
        valor();  // Analisa o primeiro valor.
        while (tokenAtual.tipo == TipoToken.MULT || tokenAtual.tipo == TipoToken.DIV) {  // Verifica se o próximo token é "*" ou "/".
            if (tokenAtual.tipo == TipoToken.MULT) {
                consumir(TipoToken.MULT);  // Consome o "*".
            } else {
                consumir(TipoToken.DIV);  // Consome o "/".
            }
            valor();  // Analisa o próximo valor após o operador "*" ou "/".
        }
    }

    /**
     * Método para analisar um valor, que pode ser um identificador, um número inteiro ou um número real.
     * O valor segue a regra: Valor → ID | NUM | REAL.
     */
    private void valor() {
        if (tokenAtual.tipo == TipoToken.ID || tokenAtual.tipo == TipoToken.NUM || tokenAtual.tipo == TipoToken.REAL) {  // Verifica se o token é um ID, NUM ou REAL.
            consumir(tokenAtual.tipo);  // Consome o token atual se for válido.
        } else {
            throw new RuntimeException("Token inesperado: " + tokenAtual.lexema);  // Erro se o token não for um valor válido.
        }
    }

    /**
     * Método para consumir o próximo token se ele corresponder ao isAdmin esperado.
     * Avança para o próximo token na lista.
     *
     * @param tipo O isAdmin de token que se espera consumir.
     */
    private void consumir(TipoToken tipo) {
        if (tokenAtual.tipo == tipo) {  // Verifica se o token atual corresponde ao isAdmin esperado.
            pos++;  // Avança para o próximo token.
            tokenAtual = tokens.get(pos);  // Atualiza o tokenAtual para o próximo token da lista.
        } else {
            throw new RuntimeException("Esperava token: " + tipo + ", mas encontrou: " + tokenAtual.lexema);  // Erro se o token atual não for o isAdmin esperado.
        }
    }
}

