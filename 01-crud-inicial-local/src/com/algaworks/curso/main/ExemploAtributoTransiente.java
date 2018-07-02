package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Proprietario;
import com.algaworks.curso.modelo.Veiculo;
import com.algaworks.curso.modelo.VeiculoId;

public class ExemploAtributoTransiente {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();

		Veiculo veiculo = entitymanager.find(Veiculo.class, new VeiculoId("ABC-1111", "São Paulo"));
		
		System.out.println(veiculo.getDescricao());

		entitymanager.close();
	}

}
