package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CidadesInterface;
import com.algaworks.curso.jpa2.dao.EstadosInterface;
import com.algaworks.curso.jpa2.dao.NFeInterface;
import com.algaworks.curso.jpa2.modelo.Cidade;
import com.algaworks.curso.jpa2.modelo.Estado;
import com.algaworks.curso.jpa2.modelo.NFe;
import com.algaworks.curso.jpa2.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroNFeBean implements Serializable {

private static final long serialVersionUID = 1L;
	
	private List<Estado> listaEstados;
	
	private List<Cidade> listaCidadesDoEstado;
	
	private NFe nfe;

	@Inject
	private CidadesInterface cidades;
	
	@Inject
	private EstadosInterface estados;
	
	@Inject 
	private NFeInterface notasFiscais;

	@PostConstruct
	public void init() {
		this.nfe = new NFe();
		this.nfe.setCidade(new Cidade());
		
		this.listaEstados = this.estados.todos();
		this.listaCidadesDoEstado = null;
	}

	public void salvar() {
		this.nfe = this.notasFiscais.guardar(this.nfe);
		FacesMessages.info(String.format("Nota Fiscal código %d salva com sucesso.", this.nfe.getCodigo()));
		this.init();
	}
	
	public void buscarCidadesDoEstado() {
		this.listaCidadesDoEstado = this.cidades.buscarCidadesPorEstado(this.nfe.getCidade().getEstado());
	}
	
	public NFe getNfe() {
		return nfe;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public List<Cidade> getListaCidadesDoEstado() {
		return listaCidadesDoEstado;
	}


}
