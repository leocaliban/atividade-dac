package com.leocaliban.atividade.biblioteca.dao.exceptions;

import com.leocaliban.atividade.biblioteca.BibliotecaException;

public class PersistenciaBibliotecaException extends BibliotecaException {

	private static final long serialVersionUID = 1780243892137781599L;

	public PersistenciaBibliotecaException(String mensagem) {
		super(mensagem);
	}

	public PersistenciaBibliotecaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
