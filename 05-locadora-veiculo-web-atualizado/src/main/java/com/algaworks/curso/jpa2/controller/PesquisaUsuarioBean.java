package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.UsuarioComGrupo;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigoUsuario;
	
	private UsuarioComGrupo usuario;
	
	@Inject
	private EntityManager manager;

	public void pesquisar() {
		this.usuario = this.manager.find(UsuarioComGrupo.class, this.codigoUsuario);
	}
	
	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public UsuarioComGrupo getUsuario() {
		return usuario;
	}
}