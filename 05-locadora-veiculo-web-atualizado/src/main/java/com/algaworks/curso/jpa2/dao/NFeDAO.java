package com.algaworks.curso.jpa2.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.NFe;
import com.algaworks.curso.jpa2.util.jpa.Transactional;


public class NFeDAO implements NFeInterface {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Override
	@Transactional
	public NFe guardar(NFe nfe) {
		return this.manager.merge(nfe);
	}

}