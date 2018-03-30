package com.leocaliban.atividade.biblioteca.service;

import java.io.Serializable;
import java.util.List;

import com.leocaliban.atividade.biblioteca.dao.ItemBibliotecaDAO;
import com.leocaliban.atividade.biblioteca.dao.exceptions.PersistenciaBibliotecaException;
import com.leocaliban.atividade.biblioteca.domain.ItemBiblioteca;
import com.leocaliban.atividade.biblioteca.filters.ItemBibliotecaFilter;
import com.leocaliban.atividade.biblioteca.service.exceptions.ServiceBibliotecaException;

public class ItemBibliotecaService implements Serializable {

	private static final long serialVersionUID = -7803325791425670859L;
	
	private ItemBibliotecaDAO itemDAO = new ItemBibliotecaDAO();
	
	public void salvar(ItemBiblioteca item) throws ServiceBibliotecaException {
		try {
		    verificarISBN(item);
			itemDAO.salvar(item);
		} 
		catch (PersistenciaBibliotecaException e) {
			throw new ServiceBibliotecaException(e.getMessage(), e);
		}
	}

	public void editar(ItemBiblioteca item) throws ServiceBibliotecaException {
		
		try {
		    verificarISBN(item);
			itemDAO.editar(item);
		} 
		catch (PersistenciaBibliotecaException e) {
			throw new ServiceBibliotecaException(e.getMessage(), e);
		}
	}

	public void deletar(ItemBiblioteca item) throws ServiceBibliotecaException {
		try {
			itemDAO.deletar(item);
		} 
		catch (PersistenciaBibliotecaException e) {
			throw new ServiceBibliotecaException(e.getMessage(), e);
		}
	}

	public ItemBiblioteca buscarPorId(int id) throws ServiceBibliotecaException {
		try {
			return itemDAO.buscarPorId(id);
		} 
		catch (PersistenciaBibliotecaException e) {
			throw new ServiceBibliotecaException(e.getMessage(), e);
		}
	}

	public List<ItemBiblioteca> buscarTodos() throws ServiceBibliotecaException {
		try {
			return itemDAO.buscarTodos();
		} 
		catch (PersistenciaBibliotecaException e) {
			throw new ServiceBibliotecaException(e.getMessage(), e);
		}
	}

	public List<ItemBiblioteca> findBy(ItemBibliotecaFilter filter) throws ServiceBibliotecaException {
		try {
			return itemDAO.findBy(filter);
		} 
		catch (PersistenciaBibliotecaException e) {
			throw new ServiceBibliotecaException(e.getMessage(), e);
		}
	}
	
	private void verificarISBN(ItemBiblioteca item) throws ServiceBibliotecaException {
	    boolean existe = itemDAO.isIsbnDuplicado(item);
	    if(existe) {
	        throw new ServiceBibliotecaException("Não é possível salvar itens com mesmo ISBN: " + item.getiSBN());
	    }
	}
}
