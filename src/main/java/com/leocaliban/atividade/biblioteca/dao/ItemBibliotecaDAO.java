package com.leocaliban.atividade.biblioteca.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.leocaliban.atividade.biblioteca.dao.exceptions.PersistenciaBibliotecaException;
import com.leocaliban.atividade.biblioteca.domain.ItemBiblioteca;
import com.leocaliban.atividade.biblioteca.filters.ItemBibliotecaFilter;


public class ItemBibliotecaDAO {
	
	private static Map<Integer, ItemBiblioteca> REPOSITORY = new ConcurrentHashMap<Integer, ItemBiblioteca>(new HashMap<Integer, ItemBiblioteca>());

	private static AtomicInteger ID = new AtomicInteger();

	public void salvar(ItemBiblioteca item) throws PersistenciaBibliotecaException {
		item.setId(ID.getAndIncrement());
		REPOSITORY.put(item.getId(), item);
	}

	public void editar(ItemBiblioteca item) throws PersistenciaBibliotecaException {
		REPOSITORY.put(item.getId(), item);
	}

	public void deletar(ItemBiblioteca item) throws PersistenciaBibliotecaException {
		REPOSITORY.remove(item.getId());
	}

	public ItemBiblioteca buscarPorId(int itemId) throws PersistenciaBibliotecaException {
		return REPOSITORY.get(itemId);
	}

	public List<ItemBiblioteca> buscarTodos() throws PersistenciaBibliotecaException {
		return new ArrayList<ItemBiblioteca>(REPOSITORY.values());
	}

	public List<ItemBiblioteca> findBy(ItemBibliotecaFilter filter) throws PersistenciaBibliotecaException {

		if (filter == null || filter.isEmpty()) {
			return new ArrayList<>(REPOSITORY.values());
		}

		List<ItemBiblioteca> resultado = new ArrayList<>();

		for (ItemBiblioteca item : REPOSITORY.values()) {
			// Título
			if (notEmpty(filter.getTitulo())) {
				if (!contains(item.getTitulo(), filter.getTitulo())) {
					continue;
				}
			}

			// Editora
			if (notEmpty(filter.getEditora())) {
				if (!contains(item.getEditora(), filter.getEditora())) {
					continue;
				}
			}

			// Data Publicação min
			if (notEmpty(filter.getDataPublicacaoMin())) {
				if (!assertDate(item.getDataPublicacao(), filter.getDataPublicacaoMin(), true)) {
					continue;
				}
			}
			
			// Data Publicação max
			if (notEmpty(filter.getDataPublicacaoMax())) {
				if (!assertDate(item.getDataPublicacao(), filter.getDataPublicacaoMax(), false)) {
					continue;
				}
			}
			
			// ISBN
			if (notEmpty(filter.getiSBN())) {
                if (!contains(item.getiSBN(), filter.getiSBN())) {
                    continue;
                }
            }
			
			// Páginas min
			if (notEmpty(filter.getMinimoPaginas())) {
				if (item.getQuantidadePaginas() < filter.getMinimoPaginas() ) {
					continue;
				}
			}
			
			// Páginas max
			if (notEmpty(filter.getMaximoPaginas())) {
				if (item.getQuantidadePaginas() > filter.getMaximoPaginas()) {
					continue;
				}
			}

			// Tipo
			if (notEmpty(filter.getTipo())) {
				if (!equals(filter.getTipo(), item.getTipo())) {
					continue;
				}
			}
			resultado.add(item);
		}
		return resultado;
	}
	
	//isbn deve ser único para cada item
	public boolean isIsbnDuplicado (ItemBiblioteca item) {
	    if(item == null) {
	        return false;
	    }
	    for (ItemBiblioteca varItem : REPOSITORY.values()) {
	        boolean isbn = varItem.getiSBN().trim().equalsIgnoreCase(item.getiSBN());
	        boolean mesmoItem = varItem.getId().equals(item.getId());
	        
	        if(isbn && !mesmoItem) {
	            return true;
	        }
	    }
	    return false;
	}
	
	

	private boolean equals(Object obj1, Object obj2) {
		return obj1.equals(obj2);
	}

	private boolean assertDate(Date date, Date dateLimit, boolean atLeast) {
		if (date == null) {
			return true;
		}
		if (atLeast) {
			return date.compareTo(dateLimit) >= 0;
		} else {
			// atMost
			return date.compareTo(dateLimit) <= 0;
		}
	}

	private boolean contains(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if (s1 == null || s2 == null) {
			return false;
		}

		return s1.toUpperCase().contains(s2.toUpperCase());
	}
	
	private boolean notEmpty(Object obj) {
		return obj != null;
	}
	
	private boolean notEmpty(String obj) {
		return obj != null && !obj.trim().isEmpty();
	}
}
