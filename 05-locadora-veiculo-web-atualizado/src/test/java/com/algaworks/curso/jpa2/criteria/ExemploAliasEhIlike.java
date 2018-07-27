package com.algaworks.curso.jpa2.criteria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Categoria;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

public class ExemploAliasEhIlike {

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
	public void exemploAliasEIlike() {
		String testeInput = "volks"; //simulaçao de inserçao do input
		
		Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(Carro.class);
		
		criteria.createAlias("modelo", "m"); //ALIAS
		criteria.createAlias("m.fabricante", "f"); //ALIAS
		
		criteria.add(Restrictions.ilike("f.nome", testeInput, MatchMode.ANYWHERE)); // equivalente ao ilike do sql. o matchmode indica onde queremos encontrar a string
		
		
		List<Carro> carros = criteria.list();
		for (Carro carro : carros) {
			System.out.println(carro.getPlaca());
		}
	}
}


