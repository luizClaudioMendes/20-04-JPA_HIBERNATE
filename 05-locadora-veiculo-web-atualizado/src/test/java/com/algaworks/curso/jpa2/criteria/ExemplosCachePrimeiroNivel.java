package com.algaworks.curso.jpa2.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Carro;

public class ExemplosCachePrimeiroNivel {

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
	
	/*
	 * neste exemplo, o entitymanager sao dois, aberto no inicio do metodo e fechado no final da primeira consulta 
	 * e é criado outro logo em seguida,
	 * que nao tem em cache os valores dos selects e 
	 * por isso é repetindo o select novamente.
	 * 
	 */
	@Test
	public void exemploSemCache() {
		TypedQuery<Carro> query = this.manager.createQuery("from Carro c", Carro.class);
		List<Carro> carros = query.getResultList();
		
		for (Carro carro : carros) {
			System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
		}
		
		//aqui fechamos o entitymanager
		this.manager.close();
		//aqui reabrimos o entitymanager
		this.manager = factory.createEntityManager();
		
		
		System.out.println("------------------------------------");
		Carro carro = this.manager.find(Carro.class, 10L);
		System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
	}
	
	/*
	 * neste exemplo, o entitymanager é somente um, aberto no inicio do metodo e fechado somente no final do metodo
	 * mantendo em cache todos os valores dos selects e nao repetindo-os novamente.
	 * 
	 */
	@Test
	public void exemploComCache() {
		TypedQuery<Carro> query = this.manager.createQuery("from Carro c", Carro.class);
		List<Carro> carros = query.getResultList();
		
		for (Carro carro : carros) {
			System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
		}
		
		
		
		System.out.println("------------------------------------");
		Carro carro = this.manager.find(Carro.class, 10L);
		System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
		
	}
	
}










