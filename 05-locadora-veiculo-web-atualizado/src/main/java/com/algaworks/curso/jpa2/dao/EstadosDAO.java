package com.algaworks.curso.jpa2.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Estado;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class EstadosDAO implements EstadosInterface {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Override
	@Transactional
	public Estado guardar(Estado estado) {
		return manager.merge(estado);
	}

	@Override
	public List<Estado> todos() {
		return this.manager.createQuery("from Estado", Estado.class).getResultList();
	}

	@Override
	public Estado peloCodigo(Long codigo) {
		return this.manager.find(Estado.class, codigo);
	}

}