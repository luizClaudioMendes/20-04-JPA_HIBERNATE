package com.algaworks.curso.jpa2.novidadesJPA;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Fatura;

public class NovidadesJPADeleteUpdateCriteria {

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
		
//		List<Date> dates = new ArrayList<>();
//		
//		for(int i = 1; i < 13; i++) {
//			Date data = Date.from(LocalDate.of(2018, i, 1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//			dates.add(data);
//		}
//		
//		this.manager.getTransaction().begin();
//		for(int i = 0; i < dates.size() ; i++) {
//			Fatura fat = new Fatura();
//			fat.setValor(new BigDecimal("200.0"));
//			fat.setVencida(false);
//			fat.setVencimento(dates.get(i));
//			
//			this.manager.persist(fat);
//		}
//		this.manager.getTransaction().commit();
	}
	
	@After
	public void tearDown() {
		System.out.println("INICIANDO O TEARDOWN");
		this.manager.close();
	}
	
	/*
	 * o criteria do JPA 2.1 possui o metodo para 
	 * fazer update em massa
	 */
	@Test
	public void exemploCriteriaUpdate() {
		this.manager.getTransaction().begin();
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaUpdate<Fatura> criteria = builder.createCriteriaUpdate(Fatura.class);
		Root<Fatura> root = criteria.from(Fatura.class);
		
		criteria.set("vencida", true) //clausa SET do update
				.where(builder.lessThan(root.<Date>get("vencimento"), Date.from(LocalDate.of(2018, 7, 20).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))); //clausula where
		
		Query query = this.manager.createQuery(criteria);
		query.executeUpdate();
		this.manager.getTransaction().commit();
	}
	
	/*
	 * o criteria do JPA 2.1 possui o metodo para 
	 * fazer delete em massa
	 */
	@Test
	public void exemploCriteriaDelete() {
		this.manager.getTransaction().begin();
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaDelete<Fatura> criteria = builder.createCriteriaDelete(Fatura.class);
		Root<Fatura> root = criteria.from(Fatura.class);
		
		criteria.where(builder.lessThan(root.<Date>get("vencimento"), new Date()));
		
		Query query = this.manager.createQuery(criteria);
		query.executeUpdate();
		this.manager.getTransaction().commit();
	}
	
}


