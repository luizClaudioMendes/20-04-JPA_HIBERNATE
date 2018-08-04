package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CidadesInterface;
import com.algaworks.curso.jpa2.dao.EstadosInterface;
import com.algaworks.curso.jpa2.modelo.Cidade;
import com.algaworks.curso.jpa2.modelo.Estado;
import com.algaworks.curso.jpa2.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroCidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cidade cidade;
	
	private List<Estado> listaEstados;

	@Inject
	private CidadesInterface cidades;
	
	@Inject
	private EstadosInterface estados;

	@PostConstruct
	public void init() {
		this.cidade = new Cidade();
		this.listaEstados = this.estados.todos();
	}

	public void salvar() {
		this.cidade = this.cidades.guardar(this.cidade);
		FacesMessages.info(String.format("Cidade código %d salva com sucesso.", this.cidade.getCodigo()));
		this.cidade = new Cidade();
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

}
