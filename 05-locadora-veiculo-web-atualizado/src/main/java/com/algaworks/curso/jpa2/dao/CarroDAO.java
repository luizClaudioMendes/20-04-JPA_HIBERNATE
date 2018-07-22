package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Carro buscarPeloCodigo(Long codigo) {
		return manager.find(Carro.class, codigo);
	}
	
	public Carro buscarComModeloPeloCodigo(Long codigo) {
		return manager.createQuery("select c from Carro c inner join fetch c.modelo where c.codigo = :codigo", Carro.class)
				.setParameter("codigo", codigo)
				.getSingleResult();
	}
	
	public void salvar(Carro carro) {
		manager.merge(carro);
	}

	public List<Carro> buscarTodos() {
		return manager.createNamedQuery("Carro.buscarTodos", Carro.class).getResultList();  //utiliza a named query criada na entidade Carro
	}
	
	@Transactional
	public void excluir(Carro carro) throws NegocioException {
		carro = buscarPeloCodigo(carro.getCodigo());
		
		try {
			manager.remove(carro);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Carro não pode ser excluído.");
		}
	}

	public Carro buscarAcessorios(Long codigo) {
		return manager.createNamedQuery("Carro.buscarCarroComAcessorios", Carro.class)  //utiliza a named query criada na entidade Carro
				.setParameter("codigo", codigo) //utiliza o setParameter normalmente
				.getSingleResult();
	}

	/*
	 * este metodo é utilizado na paginacao
	 */
	public List<Carro> buscarComPaginacao(int first, int pageSize) {
		return manager.createNamedQuery("Carro.buscarTodos", Carro.class)
							.setFirstResult(first) //utilizado na paginacao
							.setMaxResults(pageSize) //utilizado na paginacao
							.getResultList();
	}

	public Long encontrarQuantidadeDeCarros() {
		return manager.createQuery("select count(c) from Carro c", Long.class).getSingleResult(); //utilizado na paginacao
	}
	
	public void setEntityManager(EntityManager em) {
		this.manager = em;
	}

	/**
	 * exemplo de criteria do hibernate com subselect
	 * @param pageSize 
	 * @param first 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Carro> buscarCarrosNuncaAlugados(int first, int pageSize) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Carro.class);
		/*
		 * select * from carro where codigo not in ( select codigo_carro from aluguel
		 * where codigo_carro is not null)
		 */

		//OBS: se deixar buscar pelos nulos corre o risco de nao trazer nenhum, pois se existir
		//algum valor nulo, ele inviabiliza o select
		
		//o DetachedCriteria é o objeto utilizado nos subselect do criteria do hibernate
		DetachedCriteria criteriaAluguel = DetachedCriteria.forClass(Aluguel.class)
				.setProjection(Projections.property("carro")) //queremos somente o id do carro
				.add(Restrictions.isNotNull("carro")); // clausula where

		criteria.setFirstResult(first); //paginador
		criteria.setMaxResults(pageSize); //paginador
		
		criteria.add(Property.forName("codigo").notIn(criteriaAluguel)); //inserçao do subselect no select principal

		return criteria.list();
		
		
		
//		JPA CRITERIA /////////////////////////////
		/*
		Subquery<Aluguel> subquery = criteriaQuery.subquery(Aluguel.class);
		  Root<Aluguel> rootAluguel = subquery.from(Aluguel.class);
		  subquery.select(rootAluguel.get("carro.codigo"));
		  subquery.where(criteriaBuilder.isNotNull("carro.codigo"));

		  CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		  CriteriaQuery<Carro> criteriaQuery = criteriaBuilder.createQuery();
		  Root<Carro> root = criteriaQuery.from(Carro.class);
		  criteriaQuery.where(root.get("codigo").in(subquery).not());

		  TypedQuery<Lancamento> query = entityManager.createQuery(criteriaQuery);    
		  return query.getResultList();
		
*/
	}
	
}
