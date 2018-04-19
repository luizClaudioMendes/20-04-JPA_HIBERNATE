package com.algaworks.curso.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entitymanager;

	public static EntityManager createEntityManager() {
		entityManagerFactory = getEntityManagerFactory();
		entitymanager = getEntityManager();
		return entitymanager;
	}

	private static EntityManager getEntityManager() {
		if(entitymanager == null) {
			entitymanager = entityManagerFactory.createEntityManager();
		}
		return entitymanager;
	}

	private static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		}
		return entityManagerFactory;
	}

}
