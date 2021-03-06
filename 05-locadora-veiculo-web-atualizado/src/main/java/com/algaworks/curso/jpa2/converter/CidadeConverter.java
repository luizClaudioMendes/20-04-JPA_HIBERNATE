package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.CidadesInterface;
import com.algaworks.curso.jpa2.modelo.Cidade;



@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter {

	@Inject
	private CidadesInterface cidades;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cidade cidade = null;

		if (value != null) {
			cidade = this.cidades.peloCodigo(new Long(value));
		}

		return cidade;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Cidade) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}