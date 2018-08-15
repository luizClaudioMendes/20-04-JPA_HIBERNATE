package com.algaworks.curso.jpa2.util.jpa;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * classe utilizada na injecao de entitymanager
 */
@RequestScoped
public class EntityManagerProducer {

	@PersistenceContext(unitName="locadoraVeiculoPU")
	private EntityManager manager;
	
	@Produces
	@RequestScoped
	public EntityManager create() {
		return manager;
	}


	
	
//	JTA - WILDFLY

}
