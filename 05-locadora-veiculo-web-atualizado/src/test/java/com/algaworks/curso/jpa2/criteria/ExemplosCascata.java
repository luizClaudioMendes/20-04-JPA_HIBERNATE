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
		carro.setCor("Azul");
		carro.setPlaca("CCC-0123");
		
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
	public void testeDeTeste() {
		System.out.println("TESTE DE TESTE");
	}
	
	@Test
	public void exercicio1() {
		/*
		 * exercicio do capitulo 9.2
		 */
		System.out.println("CRIANDO NOVO CARRO");
		Carro carro = new Carro();
		carro.setCor("Azul");
		carro.setPlaca("CCC-0124");
		
		System.out.println("CRIANDO NOVO ACESSORIO");
		Acessorio ace0 = new Acessorio();
		ace0.setDescricao("aquecedor de bancos");
		
		Acessorio ace1 = new Acessorio();
		ace1.setDescricao("espelhos retrateis");
		
		Acessorio ace2 = new Acessorio();
		ace2.setDescricao("Camera de re");
		
		Acessorio ace3 = new Acessorio();
		ace3.setDescricao("sensor de estacionamento");
		
		List<Acessorio> listaAcessorios = new ArrayList<>(0);
		
		listaAcessorios.add(ace0);
		listaAcessorios.add(ace1);
		listaAcessorios.add(ace2);
		listaAcessorios.add(ace3);
		
		carro.setAcessorios(listaAcessorios);
		
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
		Carro carro = this.manager.find(Carro.class, 13L);
		try {
			this.manager.getTransaction().begin();
			System.out.println("APAGANDO O CARRO");
			this.manager.remove(carro);
			this.manager.getTransaction().commit();
			System.out.println("CARRO APAGADO");
		}catch (Exception e) {
			System.out.println("ERRO AO APAGAR O CARRO");
			e.printStackTrace();
		}
	}
	
	@Test
	public void exclusaoDeObjetosOrfaos() {
		Carro carro = this.manager.find(Carro.class, 12L);
		
		for (Aluguel aluguel : carro.getAlugueis()) {
			System.out.println("Alugueis:" + aluguel.getCodigo());
		}
		
		
		System.out.println("REMOVENDO O ALUGUEL :"+carro.getAlugueis().get(0).getCodigo());
		
		this.manager.getTransaction().begin();
		carro.getAlugueis().remove(0);
		this.manager.getTransaction().commit();
		
		for (Aluguel aluguel : carro.getAlugueis()) {
			System.out.println("Alugueis PERSISTIDOS:" + aluguel.getCodigo());
		}
	}
}


