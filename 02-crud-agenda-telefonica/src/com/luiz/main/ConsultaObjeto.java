package com.luiz.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luiz.modelo.Agenda;

public class ConsultaObjeto {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		
		Agenda agenda =  entitymanager.find(Agenda.class, 2L);
		
		if(agenda != null) {
			System.out.println("Agenda de "+agenda.getNome()+" com numero "+agenda.getTelefone());
		}else {
			System.out.println("agenda nao encontrada");
		}

	}

}
