package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

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
	
}
