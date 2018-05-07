package com.leocaliban.atividade.biblioteca.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.leocaliban.atividade.biblioteca.domain.ItemBiblioteca;
import com.leocaliban.atividade.biblioteca.filters.ItemBibliotecaFilter;
import com.leocaliban.atividade.biblioteca.service.ItemBibliotecaService;
import com.leocaliban.atividade.biblioteca.service.exceptions.ServiceBibliotecaException;

@RequestScoped
@ManagedBean
public class PesquisaItemBean extends AbstractBean {

	private static final long serialVersionUID = -5976838804313515033L;
	
	private List<ItemBiblioteca> itens;

	private ItemBibliotecaService service = new ItemBibliotecaService();

	private ItemBibliotecaFilter filter;
	
	//quando não existe nenhum dado salvo
	public boolean isSemRegistro() {
	    try {
            if(service.buscarTodos().isEmpty()) {
                return true;
            }
        }
        catch (ServiceBibliotecaException e) {
            reportarMensagemDeErro(e.getMessage());
        }
	    return false;
	}
		
	//quando o usuário filtra mas não encontra resultado, a lista fica vazia mas o banco não
	public boolean isVazio() {
	    try {
            if(!service.buscarTodos().isEmpty() && isListaItensVazia()) {
                return true;
            }
        }
        catch (ServiceBibliotecaException e) {
            reportarMensagemDeErro(e.getMessage());
        }
        return false;
	}
	
	public boolean isListaItensVazia() {
	    return itens.isEmpty();
	}

	public List<ItemBiblioteca> getItens() {
		return itens;
	}

	public ItemBibliotecaFilter getFilter() {
		return filter;
	}

	public void setFilter(ItemBibliotecaFilter filter) {
		this.filter = filter;
	}

	@PostConstruct
	public void init() {
	    limpar();
		filtrar();
	}

    public String filtrar() {
		try {
			itens = service.findBy(getFilter());
		} 
		catch (ServiceBibliotecaException e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		return null;
	}

	public String limpar() {
		this.filter = new ItemBibliotecaFilter();
		return null;
	}
	
	public String deletar(ItemBiblioteca itemBiblioteca) {
        try {
            service.deletar(itemBiblioteca);
        } 
        catch (ServiceBibliotecaException e) {
            reportarMensagemDeErro(e.getMessage());
            return null;
        }
        reportarMensagemDeSucesso("O item '" + itemBiblioteca.getTitulo() + "' foi excluído com sucesso!");
        return "index.xhtml?faces-redirect=true";
    }
}
