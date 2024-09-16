package model.exception;

public class IsbnException extends Exception {

	public IsbnException(){
        super("O valor do isbn deve ter tamanho pelo menos 13");
    }
}
