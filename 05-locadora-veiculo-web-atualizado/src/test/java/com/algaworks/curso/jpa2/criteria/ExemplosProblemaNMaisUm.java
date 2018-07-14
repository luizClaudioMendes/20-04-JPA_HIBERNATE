package com.algaworks.curso.jpa2.criteria;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Carro_;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro_;

public class ExemplosProblemaNMaisUm {

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
	
	/**
	 * este teste mostra o problema que ocorre em anotaçoes 
	 * @ManyToOne
	 * 
	 * para cada carro encontrado na tabela, ele ira fazer outro
	 * select para buscar o modelo, ficando assim ineficiente
	 */
	@Test
	public void ProblemaNMaisUm () {
		TypedQuery<Carro> query = this.manager.createQuery("from Carro c", Carro.class);
		List<Carro> carros = query.getResultList();
		
		for (Carro carro : carros) {
			System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
			
		}
	}
	
	/**
	 * correcao do problema n + 1 usando HQL.
	 * desta forma ele ira executar somente uma consulta e 
	 * junto com o inner join nao ira fazer varias outras consultas,
	 * sendo que no primeiro select ele já ira trazer todas as
	 * informaçoes necessarias.
	 */
	@Test
	public void ProblemaNMaisUmCorrecaoHQL () {
		TypedQuery<Carro> query = this.manager.createQuery("from Carro c inner join fetch c.modelo", Carro.class);
		List<Carro> carros = query.getResultList();
		
		for (Carro carro : carros) {
			System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
			
		}
	}
	
	/**
	 * correcao do problema n + 1 usando SQL.
	 * desta forma ele ira executar somente uma consulta e 
	 * junto com o inner join nao ira fazer varias outras consultas,
	 * sendo que no primeiro select ele já ira trazer todas as
	 * informaçoes necessarias.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void ProblemaNMaisUmCorrecaoSQL () {
		TypedQuery<Carro> query = (TypedQuery<Carro>) this.manager.createNativeQuery("select * from carro c inner join modelo m on m.id_modelo = c.modelo "); //query ficticia, nao coincide com os ids passados, somente para demonstracao
		List<Carro> carros = query.getResultList();
		
		for (Carro carro : carros) {
			System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
			
		}
	}
	
	/**
	 * correcao do problema n + 1 usando CRITERIA.
	 * desta forma ele ira executar somente uma consulta e 
	 * junto com o inner join nao ira fazer varias outras consultas,
	 * sendo que no primeiro select ele já ira trazer todas as
	 * informaçoes necessarias.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void ProblemaNMaisUmCorrecaoCriteria () {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Carro.class);
		criteria.createAlias("modelo", "m"); //Aqui faz a associação entre as entidades e busca o modelo
		List<Carro> carros = criteria.list();
		
		for (Carro carro : carros) {
			System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
			
		}
	}
	
	
}










