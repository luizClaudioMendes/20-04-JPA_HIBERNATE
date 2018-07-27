package com.algaworks.curso.jpa2.novidadesJPA;

import java.time.LocalDate;
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
import com.algaworks.curso.jpa2.modelo.Usuario;

public class NovidadesJPAConverters {

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
	public void testeExemploJPACriarOUsuario() {
		manager.getTransaction().begin();
		
		Usuario usr = new Usuario();
		usr.setNome("TEste 2");
		usr.setDataNascimento(LocalDate.of(2018, 07, 26));
		
		manager.persist(usr);
		
		manager.getTransaction().commit();;
	}
	
	@Test
	public void testeExemploJPA() {

		TypedQuery<Usuario> query = this.manager.createQuery("from Usuario c", Usuario.class);
		List<Usuario> usuarios = query.getResultList();
		
		for (Usuario user : usuarios) {
			System.out.println(user.getNome() + " / "+ user.getDataNascimento());
			
		}
		
		
		
		System.out.println("TESTE PARA DEMONSTRAR OS CONVERTERS");
	}
	
}


