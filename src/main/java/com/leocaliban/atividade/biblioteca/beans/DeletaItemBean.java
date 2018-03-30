package com.leocaliban.atividade.biblioteca.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.leocaliban.atividade.biblioteca.domain.ItemBiblioteca;
import com.leocaliban.atividade.biblioteca.service.ItemBibliotecaService;
import com.leocaliban.atividade.biblioteca.service.exceptions.ServiceBibliotecaException;

@ViewScoped
@ManagedBean
public class DeletaItemBean extends AbstractBean{

    private static final long serialVersionUID = 1L;
    
    private ItemBiblioteca itemBiblioteca;
    
    private ItemBibliotecaService service = new ItemBibliotecaService();
    
    public String deletar() {
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
    
    public String cancelar() {
        return "index.xhtml?faces-redirect=true";
    }

    public ItemBiblioteca getItemBiblioteca() {
        return itemBiblioteca;
    }

    public void setItemBiblioteca(ItemBiblioteca itemBiblioteca) {
        this.itemBiblioteca = itemBiblioteca;
    }
    
}
