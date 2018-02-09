package com.luiz.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luiz.modelo.Agenda;

public class SalvaObjeto {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		Agenda agenda = new Agenda();
		agenda.setNome("teste maximo");
		agenda.setTelefone("888888888");
		agenda.setDataRegistro(new Date());
		
		
		entitymanager.getTransaction().begin();
		entitymanager.persist(agenda);
		entitymanager.getTransaction().commit();
		
		System.out.println("objeto salvo com sucesso!");

	}

}
