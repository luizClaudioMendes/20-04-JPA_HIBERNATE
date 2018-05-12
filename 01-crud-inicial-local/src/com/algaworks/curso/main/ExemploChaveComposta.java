package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Veiculo;
import com.algaworks.curso.modelo.VeiculoId;

public class ExemploChaveComposta {

	public static void main(String[] args) {
		/*
		 * IMPORTANTE:
		 * caso ocorram erros na criação automatica das tabelas, e o erro for este:
		 * com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Specified key was too long; max key length is 1000 bytes
		 * 
		 * indica que o engine do banco foi criado usando utf-8
		 * 
		 * deve-se alterar para set GLOBAL storage_engine='InnoDb'; 
		 * 
		 * ou colocando o engine do banco como latin1
		 */
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		Veiculo v = new Veiculo();
		v.setCodigo(new VeiculoId("ABB-2222", "São Paulo"));
		v.setFabricante("honda");
		v.setModelo("civic");
		
		entitymanager.getTransaction().begin();
		entitymanager.persist(v);
		entitymanager.getTransaction().commit();
		
		
		/*
		 * este veiculo ja havia sido criado anteriormente na primeira 
		 * execuçao do metodo.
		 */
		VeiculoId codigo = new VeiculoId("ABC-1111", "São Paulo");		
		Veiculo v2 = entitymanager.find(Veiculo.class, codigo);
		
		System.out.println("VEiculo :" + v2.getCodigo().getPlaca());

	}

}
