package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.algaworks.curso.jpa2.modelo.Status;
import com.algaworks.curso.jpa2.modelo.UsuarioComGrupo;


@Named
@ViewScoped
public class SiteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Long getTotalUsuarios() {
		Session session = manager.unwrap(Session.class);
		return (Long) session.createQuery("select count(u) from UsuarioComGrupo u")
				.setCacheable(true)//definição para colocar a query em cache
				.uniqueResult();
	}
	
	public Long getUsuariosAtivos() {
		Session session = manager.unwrap(Session.class);
		return (Long) session.createCriteria(UsuarioComGrupo.class)
				.setProjection(Projections.count("codigo"))
				.add(Restrictions.eq("status", Status.ATIVO))
				.setCacheable(true)//definição para colocar a query em cache
				.uniqueResult();
	}
	
}
