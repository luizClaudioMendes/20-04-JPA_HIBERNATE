package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Status;
import com.algaworks.curso.jpa2.modelo.UsuarioComGrupo;


@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	private UsuarioComGrupo usuario = new UsuarioComGrupo();
	
	public void salvar() {
		try {
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
			usuario = new UsuarioComGrupo();
		} catch (Exception e) {
			throw new RuntimeException("Erro salvando usuario", e);
		}
	}

	public UsuarioComGrupo getUsuario() {
		if(usuario == null) {
			usuario = new UsuarioComGrupo();
		}
		return usuario;
	}

	public void setUsuario(UsuarioComGrupo usuario) {
		this.usuario = usuario;
	}
	
	public List<Status> getStatusList() {
		return Arrays.asList(Status.values());
	}
	
}
