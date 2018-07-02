package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.ProprietarioTelefones;

public class ExemploColecoesTiposBasicos {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();

		ProprietarioTelefones pt = new ProprietarioTelefones();
		pt.setNome("João");
		pt.getTelefones().add("(11) 1111-1111"); 
		pt.getTelefones().add("(11) 2222-2222");

		entitymanager.getTransaction().begin();
		entitymanager.persist(pt);
		entitymanager.getTransaction().commit();
		
		
		
		//------------------------------------------------
		
		
		ProprietarioTelefones consulta = entitymanager.find(ProprietarioTelefones.class, 1L);
		
		for (String telefone : consulta.getTelefones()) {
			System.out.println(consulta.getNome() + ":" + telefone);
		}
		
		entitymanager.close();
	}

}
