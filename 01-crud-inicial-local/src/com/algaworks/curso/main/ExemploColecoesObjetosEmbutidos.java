package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Celular;
import com.algaworks.curso.modelo.ProprietarioCelular;
import com.algaworks.curso.modelo.ProprietarioTelefones;

public class ExemploColecoesObjetosEmbutidos {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();

		ProprietarioCelular pc = new ProprietarioCelular();
		pc.setNome("Tiago");
		pc.getCelulares().add(new Celular("31", "3333-3333")); 
		pc.getCelulares().add(new Celular("41", "4444-4444"));

		entitymanager.getTransaction().begin();
		entitymanager.persist(pc);
		entitymanager.getTransaction().commit();
		
		
		
		//------------------------------------------------
		
		
//		ProprietarioCelular consulta = entitymanager.find(ProprietarioCelular.class, 1L);
//		
//		for (Celular celular : consulta.getCelulares()) {
//			System.out.println(consulta.getNome() + ":" + celular);
//		}
//		
		entitymanager.close();
	}

}
