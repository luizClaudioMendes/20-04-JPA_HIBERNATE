package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.EstadosInterface;
import com.algaworks.curso.jpa2.modelo.Estado;
import com.algaworks.curso.jpa2.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroEstadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Estado estado;

	@Inject
	private EstadosInterface estados;
	
	@PostConstruct
	public void init() {
		this.estado = new Estado();
	}

	public void salvar() {
		this.estado = this.estados.guardar(this.estado);
		FacesMessages.info(String.format("Estado código %d salvo com sucesso.", this.estado.getCodigo()));
		this.estado = new Estado();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}


}
