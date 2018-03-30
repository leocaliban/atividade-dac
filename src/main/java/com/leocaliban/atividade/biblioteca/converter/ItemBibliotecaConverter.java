package com.leocaliban.atividade.biblioteca.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.leocaliban.atividade.biblioteca.domain.ItemBiblioteca;
import com.leocaliban.atividade.biblioteca.service.ItemBibliotecaService;
import com.leocaliban.atividade.biblioteca.service.exceptions.ServiceBibliotecaException;

@FacesConverter(forClass = ItemBiblioteca.class)
public class ItemBibliotecaConverter implements Converter{

	private ItemBibliotecaService service = new ItemBibliotecaService();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}

		try {
			int id = Integer.parseInt(value);
			return service.buscarPorId(id);
		} 
		catch (ServiceBibliotecaException | NumberFormatException e) {
			String msgErroStr = String.format(
					"Erro de conversão! Não foi possível realizar a conversão da string '%s' para o tipo esperado.",
					value);
			FacesMessage msgErro = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);
			throw new ConverterException(msgErro);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (!(value instanceof ItemBiblioteca)) {
			return null;
		}
		
		Integer id = ((ItemBiblioteca) value).getId();
		return (id != null) ? id.toString() : null;
	}

}
