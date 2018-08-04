package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CidadesInterface;
import com.algaworks.curso.jpa2.modelo.Cidade;

@Named
@ViewScoped
public class PesquisaCidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Cidade> listaCidades;
	
	@Inject
	private CidadesInterface cidades;
	
	@PostConstruct
	public void init() {
		this.listaCidades = this.cidades.todas();
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}


}
