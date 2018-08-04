package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.EstadosInterface;
import com.algaworks.curso.jpa2.modelo.Estado;


@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter {

	@Inject
	private EstadosInterface estados;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Estado estado = null;

		if (value != null) {
			estado = this.estados.peloCodigo(new Long(value));
		}

		return estado;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Estado) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}
