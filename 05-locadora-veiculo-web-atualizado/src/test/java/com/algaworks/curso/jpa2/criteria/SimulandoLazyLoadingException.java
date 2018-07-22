package com.algaworks.curso.jpa2.criteria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Carro;

public class SimulandoLazyLoadingException {
	
	/*
	 * 
	 */
	
	
	private static EntityManagerFactory factory;
	
	private EntityManager manager;
	
	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("junitPU");
	}
	
	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}
	
	@After
	public void tearDown() {
		this.manager.close();
	}
	
	@Test
	public void simulaLazyLoading() {
		/*
		 * simulando um ambiente web, onde, logo apos o retorno de uma consulta, e o fechamento da sessao, 
		 * se tenta acessar uma lista LAZY
		 */
		
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Carro.class);
		
		criteria.add(Restrictions.eq("codigo", 3L));
		
		Carro c = (Carro) criteria.uniqueResult();
		
		System.out.printf("Codigo: %d. Placa: %s\n", c.getCodigo(), c.getPlaca());
		
		
		session.close();
		
		/*
		 * aqui ocorre o erro de lazyLoading
		 */
		for (Acessorio acessorio : c.getAcessorios()) {
			System.out.println(acessorio.getDescricao());
		}
	}
	
	@Test
	public void simulaLazyLoadingCorrigido() {
		/*
		 * simulando um ambiente web, onde, logo apos o retorno de uma consulta, e o fechamento da sessao, 
		 * se tenta acessar uma lista LAZY
		 */
		
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Carro.class);
		
		criteria.setFetchMode("acessorios", FetchMode.JOIN); //ao colocarmos neste select o fetch mode join, iremos buscar a lista

		
		criteria.add(Restrictions.eq("codigo", 3L));
		
		Carro c = (Carro) criteria.uniqueResult();
		
		System.out.printf("Codigo: %d. Placa: %s\n", c.getCodigo(), c.getPlaca());
		
		
		session.close();
		
		/*
		 * aqui nao ocorre mais o erro de lazyLoading
		 */
		for (Acessorio acessorio : c.getAcessorios()) {
			System.out.println(acessorio.getDescricao());
		}
		
		
		
		
	
	}
	
	
}










