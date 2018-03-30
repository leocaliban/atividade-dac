package com.leocaliban.atividade.biblioteca.service.exceptions;

public class ServiceBibliotecaException extends Exception {

	private static final long serialVersionUID = -3082351960302866350L;

	public ServiceBibliotecaException(String mensagem) {
		super(mensagem);
	}

	public ServiceBibliotecaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
