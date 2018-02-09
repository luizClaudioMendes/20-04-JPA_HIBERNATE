package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class RemovendoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		
		Cliente cliente = entitymanager.find(Cliente.class, 2L);
		
		
		entitymanager.getTransaction().begin();
		//IMPORTANTE -- para remover um objeto este deve estar dentro do 
		//contexto de gerenciamento do entitymanager ou seja ja deve ter
		//sido carregado pelo sistema
		entitymanager.remove(cliente);
		entitymanager.getTransaction().commit();
		
		System.out.println("cliente apagado!");
//		entitymanager.close();		

	}

}
