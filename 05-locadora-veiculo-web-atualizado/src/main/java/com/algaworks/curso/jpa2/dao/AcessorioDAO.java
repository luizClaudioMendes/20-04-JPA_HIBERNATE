package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AcessorioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Acessorio buscarPeloCodigo(Long codigo) {
		return manager.find(Acessorio.class, codigo, LockModeType.PESSIMISTIC_WRITE); //lock pessimista
		
//		tipos de locks:
//			Database name					Shared lock statement			Exclusive lock statement
//			Oracle							FOR UPDATE						FOR UPDATE
//			MySQL							LOCK IN SHARE MODE				FOR UPDATE
//			Microsoft SQL Server			WITH (HOLDLOCK, ROWLOCK)		WITH (UPDLOCK, ROWLOCK)
//			PostgreSQL						FOR SHARE						FOR UPDATE
//			DB2								FOR READ ONLY WITH RS 			FOR UPDATE WITH RS

//		The shared/read lock is acquired using the PESSIMISTIC_READ Lock Mode Type, and the exclusive/write lock is requested using PESSIMISTIC_WRITE instead.
		
	}
	
	public void salvar(Acessorio fabricante) {
		manager.merge(fabricante);
	}

	public List<Acessorio> buscarTodos() {
		return manager.createQuery("from Acessorio", Acessorio.class).getResultList();
	}
	
	@Transactional
	public void excluir(Acessorio fabricante) throws NegocioException {
		fabricante = buscarPeloCodigo(fabricante.getCodigo());
		try {
			manager.remove(fabricante);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Acessorio não pode ser excluído.");
		}
	}
	
}
