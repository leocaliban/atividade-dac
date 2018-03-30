package com.leocaliban.atividade.biblioteca.domain;

import java.util.Date;

import com.leocaliban.atividade.biblioteca.domain.enums.Tipo;

public class ItemBiblioteca {
	
	private Integer id;
	
	private String titulo;
	
	private String editora;
	
	private Date dataPublicacao;
	
	private String descricao;
	
	private String iSBN;
	
	private Integer quantidadePaginas;
	
	private String assunto;
	
	private String tags;
	
	private Tipo tipo;
	
	public ItemBiblioteca() {
		
	}
	
	public ItemBiblioteca(String titulo, String editora, Date dataPublicacao, String descricao, String iSBN,
            Integer quantidadePaginas, String assunto, String tags, Tipo tipo) {
        this.titulo = titulo;
        this.editora = editora;
        this.dataPublicacao = dataPublicacao;
        this.descricao = descricao;
        this.iSBN = iSBN;
        this.quantidadePaginas = quantidadePaginas;
        this.assunto = assunto;
        this.tags = tags;
        this.tipo = tipo;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public Integer getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public void setQuantidadePaginas(Integer quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPublicacao == null) ? 0 : dataPublicacao.hashCode());
		result = prime * result + ((editora == null) ? 0 : editora.hashCode());
		result = prime * result + ((iSBN == null) ? 0 : iSBN.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quantidadePaginas == null) ? 0 : quantidadePaginas.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemBiblioteca other = (ItemBiblioteca) obj;
		if (dataPublicacao == null) {
			if (other.dataPublicacao != null)
				return false;
		} else if (!dataPublicacao.equals(other.dataPublicacao))
			return false;
		if (editora == null) {
			if (other.editora != null)
				return false;
		} else if (!editora.equals(other.editora))
			return false;
		if (iSBN == null) {
			if (other.iSBN != null)
				return false;
		} else if (!iSBN.equals(other.iSBN))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantidadePaginas == null) {
			if (other.quantidadePaginas != null)
				return false;
		} else if (!quantidadePaginas.equals(other.quantidadePaginas))
			return false;
		if (tipo != other.tipo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemBiblioteca [id=" + id + ", titulo=" + titulo + ", editora=" + editora + ", dataPublicacao="
				+ dataPublicacao + ", descricao=" + descricao + ", iSBN=" + iSBN + ", quantidadePaginas="
				+ quantidadePaginas + ", assunto=" + assunto + ", tags=" + tags + ", tipo=" + tipo + "]";
	}
	
}
