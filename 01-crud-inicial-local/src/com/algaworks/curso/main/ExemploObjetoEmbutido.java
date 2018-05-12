package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Proprietario;
import com.algaworks.curso.modelo.Veiculo;
import com.algaworks.curso.modelo.VeiculoId;

public class ExemploObjetoEmbutido {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		Veiculo v = new Veiculo();
		v.setCodigo(new VeiculoId("ACC-3333", "Brasilia"));
		v.setFabricante("Ford");
		v.setModelo("fiesta");
		
		Proprietario prop = new Proprietario();
		prop.setNome("joao da silva");
		prop.setTelefone("1111111111111");
		prop.setEmail("joao@silva.com");
		
		v.setProp(prop);
		
		
		entitymanager.getTransaction().begin();
		entitymanager.persist(v);
		entitymanager.getTransaction().commit();
		

	}

}
