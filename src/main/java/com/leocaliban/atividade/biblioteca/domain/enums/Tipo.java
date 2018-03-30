package com.leocaliban.atividade.biblioteca.domain.enums;

/**
 * Enum {@link Tipo} que representa o tipo do Livro.
 * @author Leocaliban
 *
 * 23 de mar de 2018
 */
public enum Tipo {
	LIVRO("Livro"), LIVRO_BOLSO("Livro de bolso"), CAPA_DURA("Capa dura"), 
		EBOOK("Ebook"), REVISTA("Revista"), PERIODICO("Periódico");
	
	private String nome;
	
	private Tipo(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
