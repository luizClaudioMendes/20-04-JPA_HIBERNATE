package com.algaworks.curso.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.algaworks.curso.modelo.Cliente;
import com.algaworks.curso.util.JPAUtil;

public class ConsultaComCriteria {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntityManager();
		
		
		/*
		 * Consulta simples com CRITERIA do JPA 2.0
		 * 
		 * similar ao 
		 * 
		 * select * from Cliente
		 */
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);

		criteriaQuery.from(Cliente.class);
		
		List<Cliente> clientes = em.createQuery(criteriaQuery).getResultList();
		
		for (Cliente cliente : clientes) {
			System.out.println("Codigo:  "+ cliente.getCodigo());
			System.out.println("Nome: "+ cliente.getNome());
		}
		
		
		System.out.println("################################################");
		
		/*
		 * Consulta simples com CRITERIA do JPA 2.0
		 * 
		 * similar ao 
		 * 
		 * select c from Cliente where c.nome like = 'chaves%'
		 */
		
		CriteriaBuilder builder2 = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery2 = builder2.createQuery(Cliente.class);

		Root<Cliente> c = criteriaQuery2.from(Cliente.class); // a variavel c é a equivalente ao select c
		criteriaQuery2.select(c); // criacao do select c
		criteriaQuery2.where(builder2.like(c.get("nome"), "chaves%")); //criacao do where, passando um like, comparando o atributo nome (c.get("nome")) ao passado no segundo parametro ("chaves%"). equivalente ao c.nome like = 'chaves%'
		
		List<Cliente> clientes2 = em.createQuery(criteriaQuery2).getResultList();
		
		for (Cliente cliente : clientes2) {
			System.out.println("Codigo:  "+ cliente.getCodigo());
			System.out.println("Nome: "+ cliente.getNome());
		}
		
		
		
		em.close();
	}
}
