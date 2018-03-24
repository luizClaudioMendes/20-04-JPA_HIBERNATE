package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaModeloFiltrandoFabricante {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntitymanager();
		
		String fabricante = "ford";
		
		//MENOS ELEGANTE
		List<String> modelos1 = em.createQuery("select mc.descricao from ModeloCarro mc where mc.fabricante.nome = '"+ fabricante +"'", String.class).getResultList();
		
		for (String modelo : modelos1) {
			System.out.println(modelo);
		}
		
		System.out.println("------------------------------------------------------------------------------");
		
		/*
		 *  Positional parameter are considered deprecated; use named parameters or JPA-style positional parameters instead
		 *  
		 *  devido ao erro acima, comentamos a parte do codigo abaixo
		 */
		
//		List<String> modelos2 = em.createQuery("select mc.descricao from ModeloCarro mc where mc.fabricante.nome = ? ", String.class).setParameter(1, fabricante).getResultList();
//		
//		for (String modelo : modelos2) {
//			System.out.println(modelo);
//		}
		
		
		System.out.println("------------------------------------------------------------------------------");
		
		//MAIS ELEGANTE
		List<String> modelos3 = em.createQuery("select mc.descricao from ModeloCarro mc where mc.fabricante.nome = :fabricante ", String.class).setParameter("fabricante", fabricante).getResultList();
		
		for (String modelo : modelos3) {
			System.out.println(modelo);
		}
		
		em.close();
		
	}

}
