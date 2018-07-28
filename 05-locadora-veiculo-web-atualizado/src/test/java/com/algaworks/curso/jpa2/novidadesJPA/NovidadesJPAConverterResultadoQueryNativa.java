package com.algaworks.curso.jpa2.novidadesJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.relatorio.AlertasPorUsuario;

public class NovidadesJPAConverterResultadoQueryNativa {

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
//		for(int i = 1; i <= 4; i++) {
//			Date data = Date.from(LocalDate.of(2018, i, 1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//			dates.add(data);
//		}
//		
//		
//		this.manager.getTransaction().begin();
//		for(int i = 0; i < dates.size() ; i++) {
//			Acesso acesso = new Acesso();
//			acesso.setDataAcesso(dates.get(i));
//			
//			this.manager.persist(acesso);
//		}
//		this.manager.getTransaction().commit();
	}
	
	@After
	public void tearDown() {
		System.out.println("INICIANDO O TEARDOWN");
		this.manager.close();
	}
	
	/*
	 * exemplo sem utilizar o namedQuery
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void buscaAcessosDeUsuarios1() {
		String queryString = "select u.nome as nome, count(a.codigo) as totalAlertas from tb_usuario u, tb_acesso a where u.codigo = a.usuario group by u.nome";
		
		
		List<AlertasPorUsuario> lista = this.manager.createNativeQuery(queryString, "alertasPorUsuarioMapping").getResultList();
		
		for (AlertasPorUsuario alerta : lista) {
			System.out.println(alerta);
		}
	}
	
	/*
	 * exemplo utilizanado o namedQuery
	 * foreach do java 7
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void buscaAcessosDeUsuarios2() {
		
		
		List<AlertasPorUsuario> lista = this.manager.createNamedQuery("alertasPorUsuario").getResultList();
		
		for (AlertasPorUsuario alerta : lista) {
			System.out.println(alerta);
		}
	}
	
	/*
	 * exemplo utilizanado o namedQuery
	 * 
	 * lambda tipo 1
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void buscaAcessosDeUsuarios3() {

		List<AlertasPorUsuario> lista = this.manager.createNamedQuery("alertasPorUsuario").getResultList();
		
		lista.forEach((AlertasPorUsuario a) -> System.out.println(a));
		
	}
	
	/*
	 * exemplo utilizanado o namedQuery
	 * 
	 * lambda tipo 2
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void buscaAcessosDeUsuarios4() {

		List<AlertasPorUsuario> lista = this.manager.createNamedQuery("alertasPorUsuario").getResultList();
		
		lista.forEach( a -> System.out.println(a));
		
	}
	
	/*
	 * exemplo utilizanado o namedQuery
	 * 
	 * lambda tipo 3
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void buscaAcessosDeUsuarios5() {

		List<AlertasPorUsuario> lista = this.manager.createNamedQuery("alertasPorUsuario").getResultList();
		
		lista.forEach(System.out::println);
		
	}
	
}


