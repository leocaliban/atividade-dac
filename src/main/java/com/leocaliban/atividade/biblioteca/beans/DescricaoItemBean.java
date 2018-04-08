package com.leocaliban.atividade.biblioteca.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.leocaliban.atividade.biblioteca.domain.ItemBiblioteca;
import com.leocaliban.atividade.biblioteca.service.ItemBibliotecaService;
import com.leocaliban.atividade.biblioteca.service.exceptions.ServiceBibliotecaException;

@ViewScoped
@ManagedBean
public class DescricaoItemBean extends AbstractBean{

    private static final long serialVersionUID = 1L;
 
    private List<ItemBiblioteca> itens;
    
    private ItemBiblioteca itemSelecionado;

    private ItemBibliotecaService service = new ItemBibliotecaService();

    @PostConstruct
    public void init() {
        try {
            itens = service.buscarTodos();
        } 
        catch (ServiceBibliotecaException e) {
            reportarMensagemDeErro(e.getMessage());
        }
    }

    public List<ItemBiblioteca> getItens() {
        return itens;
    }

    public void setItens(List<ItemBiblioteca> itens) {
        this.itens = itens;
    }

    public ItemBiblioteca getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(ItemBiblioteca itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }
    
}
