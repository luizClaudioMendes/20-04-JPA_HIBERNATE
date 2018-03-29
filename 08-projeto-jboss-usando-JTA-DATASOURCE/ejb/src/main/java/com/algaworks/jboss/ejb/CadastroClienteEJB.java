package com.algaworks.jboss.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algaworks.jboss.modelo.Cliente;

@Stateless
public class CadastroClienteEJB {
	
	@PersistenceContext(unitName="projetoJbossPU")
	private EntityManager em;
	//injecao utilizando o @PersistenceContext e utilizado o persistence.xml

	public void salvar(Cliente cliente) {
		em.merge(cliente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		return em.createQuery("from Cliente c").getResultList();
	}
	
}
