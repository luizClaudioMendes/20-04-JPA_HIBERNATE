package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class TesteDoCicloDeVida {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		//para atualizar um objeto no banco de dados,
		//é necessario que o objeto esteja gerenciado pelo entityManager
		Cliente cliente = entitymanager.find(Cliente.class, 1L);
		
		entitymanager.getTransaction().begin();
		cliente.setNome("lionel da silva sauro");
		cliente.setIdade(33);
		
		entitymanager.getTransaction().commit();
		
		System.out.println("cliente atualizado com sucesso!");
//		entitymanager.close();	

	}

}
