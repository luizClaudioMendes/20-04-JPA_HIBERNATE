package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class ConsultandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		Cliente cliente = entitymanager.find(Cliente.class, 1L);
		if(cliente != null) {
			System.out.println("nome: " +cliente.getNome());
			System.out.println("idade: " +cliente.getIdade());
			System.out.println("profissao: " +cliente.getProfissao());
			System.out.println("sexo: " +cliente.getSexo());
		} else {
			System.out.println("cliente nao encontrado");
		}
		
		
		
//		entitymanager.close();

	}

}
