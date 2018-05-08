package com.algaworks.curso.jpa2.criteria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Categoria;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

public class ExemplosCascata {

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
	public void exemploEntidadeTransiente() {
		/*
		 * as vezes precisamos gravar varios objetos em sequencia e sem muita preocupaçao em como fazer isso.
			para isso, podemos salvar individualmente os objetos nas sequencias necessarias (o que é trabalhoso e demorado e passivel de erros) ou podemos mandar o hibernate fazer isso para nos.

			para isso utiliza-se o cascade.

			para se utilizar o cascade, basta juntarmos a anotação cascade = CascadeType.XXXXX  no momento da definiçao do relacionamento.

			exemplo:

			@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) // o cascade = CascadeType.PERSIST permite salvar o carro e juntamente salvar secundariamente um novo modelo de carro
				public ModeloCarro getModelo() {
					return modelo;
				}
			isso fará com que, ao salvar um carro (persist), se no momento da persistencia for verificado que o modelo setado no carro nao existe em bd, ele tambem ira ser adicionado automaticamente.

		 */
		System.out.println("CRIANDO NOVO CARRO");
		Carro carro = new Carro();
		carro.setCor("Preto");
		carro.setPlaca("AAA-1111");
		
		System.out.println("CRIANDO NOVO MODELO DE CARRO");
		ModeloCarro modelo = new ModeloCarro();
		modelo.setCategoria(Categoria.ESPORTIVO);
		modelo.setDescricao("Ferrari");
		carro.setModelo(modelo);
		
		System.out.println("INICIANDO TRY");
		try {
			
			this.manager.getTransaction().begin();
			System.out.println("PERSISTINDO");
			this.manager.persist(carro);
			this.manager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println("ERRO!");
			e.printStackTrace();
		}
		
		System.out.println("CARRO PERSISTIDO!");
	}
	
	@Test
	public void exclusaoEmCascata() {
//		Carro carro = this.manager.find(Carro.class, 3L);
//		
//		this.manager.getTransaction().begin();
//		this.manager.remove(carro);
//		this.manager.getTransaction().commit();
	}
	
	@Test
	public void exclusaoDeObjetosOrfaos() {
//		Carro carro = this.manager.find(Carro.class, 6L);
//		
//		this.manager.getTransaction().begin();
//		carro.getAlugueis().remove(0);
//		this.manager.getTransaction().commit();
	}
}


