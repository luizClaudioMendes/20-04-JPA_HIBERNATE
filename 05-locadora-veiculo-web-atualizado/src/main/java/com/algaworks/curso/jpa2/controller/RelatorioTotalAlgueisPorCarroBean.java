package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.modelo.util.TotalDeAlugueisPorCarro;

@Named
@ViewScoped
public class RelatorioTotalAlgueisPorCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<TotalDeAlugueisPorCarro> alugueis;
	
	@Inject
	private CarroDAO carroDAO;

	/**
	 * metodo utilizando criteria do hibernate
	 */
	public void pesquisarCriteria() {
		this.alugueis = carroDAO.buscarTotalAlugueisPorCarro();
	}

	public List<TotalDeAlugueisPorCarro> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<TotalDeAlugueisPorCarro> alugueis) {
		this.alugueis = alugueis;
	}

}
