package com.leocaliban.atividade.biblioteca;

public class BibliotecaException extends Exception {

	private static final long serialVersionUID = -7669751088704144947L;

	public BibliotecaException(String mensagem) {
		super(mensagem);
	}

	public BibliotecaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
