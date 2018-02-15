package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class SalvandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Maria Rita");
		cliente.setIdade(20);
		cliente.setProfissao("médica");
		cliente.setSexo("F");
		
		entitymanager.getTransaction().begin();//para alteraçoes no banco de dados é necessario abrir e commitar a transacao
		entitymanager.persist(cliente);
		entitymanager.getTransaction().commit();
		
		System.out.println("cliente salvo com sucesso!");
		
//		entitymanager.close();

	}

}
