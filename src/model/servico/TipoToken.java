package model.servico;
/**
 * A enumeração TipoToken define os diferentes tipos de tokens (unidades léxicas)
 * que o analisador léxico pode identificar durante a análise de uma expressão.
 */
public enum TipoToken {

    AND,    // Representa o operador lógico AND (&&) utilizado em expressões lógicas.

    PLUS,   // Representa o operador de adição (+) utilizado em expressões aritméticas.

    MINUS,  // Representa o operador de subtração (-) utilizado em expressões aritméticas.

    MULT,   // Representa o operador de multiplicação (*) utilizado em expressões aritméticas.

    DIV,    // Representa o operador de divisão (/) utilizado em expressões aritméticas.

    ASSIGN, // Representa o operador de atribuição (=) usado para atribuir valores a variáveis.

    ID,     // Representa um identificador, que geralmente é o nome de uma variável.

    NUM,    // Representa uma constante numérica inteira (números inteiros).

    REAL,   // Representa uma constante numérica real (números com ponto flutuante).

    EOF     // Representa o final da entrada (End of File), utilizado para indicar o término da análise.
}
