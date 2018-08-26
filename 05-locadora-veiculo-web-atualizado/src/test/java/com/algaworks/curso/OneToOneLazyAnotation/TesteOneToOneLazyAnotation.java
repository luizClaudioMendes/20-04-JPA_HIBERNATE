package com.algaworks.curso.OneToOneLazyAnotation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.UsuarioComEndereco;

public class TesteOneToOneLazyAnotation {

	private static EntityManagerFactory factory;
	
	private EntityManager manager;
	
	@BeforeClass
	public static void init() {
		System.out.println("INICIANDO O INIT");
		try {
			factory = Persistence.createEntityManagerFactory("junitPU");
		}catch (Throwable e) {
			System.out.println("ERRO NO INIT");
			e.printStackTrace();
		}
	}
	
	@Before
	public void setUp() {
		System.out.println("INICIANDO O SETUP");
		this.manager = factory.createEntityManager();
	}
	
	@After
	public void tearDown() {
		System.out.println("INICIANDO O TEARDOWN");
		this.manager.close();
	}
	
	@Test
	public void testaAnotacaoOneToOneLazy() {
		UsuarioComEndereco u = manager.find(UsuarioComEndereco.class, 1L); // o hibernate ira carregar a entidade usuario sem o endereco
		
		/*
		 * como o entitymanager ainda nao fechou, se chamarmos o endereco, ai o hibernate ira no banco
		 */
		System.out.println(u.getEndereco().getRua());
	}
	
	@Test
	public void testaAnotacaoOneToOneLazyFechandoOEntityManager() {	
		UsuarioComEndereco u = manager.find(UsuarioComEndereco.class, 1L); // o hibernate ira carregar a entidade usuario sem o endereco
		manager.close();
		
		try {
			this.manager = factory.createEntityManager();
		
			/*
			 * como o entitymanagerja fechou, se chamarmos o endereco, ai o hibernate gera o erro 
			 * org.hibernate.LazyInitializationException: session is not connected
			 */
			System.out.println(u.getEndereco().getRua());
		} catch (Exception e) {
			System.out.println("ENTROU NO CATCH");
			e.printStackTrace();
		}
	}
	
	
}


