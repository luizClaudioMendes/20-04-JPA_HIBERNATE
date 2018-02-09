package com.luiz.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luiz.modelo.Agenda;

public class UpdateObjeto {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		Agenda agenda = entitymanager.find(Agenda.class, 2L);
		
		entitymanager.getTransaction().begin();
		agenda.setTelefone("7878787878");
		entitymanager.getTransaction().commit();
		
		System.out.println("objeto alterado");

	}

}
