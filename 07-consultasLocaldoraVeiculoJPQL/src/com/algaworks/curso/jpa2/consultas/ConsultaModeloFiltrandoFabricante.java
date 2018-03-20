package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaModeloFiltrandoFabricante {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntitymanager();
		
		List<String> modelos = em.createQuery("select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'ford'", String.class).getResultList();
		
		for (String modelo : modelos) {
			System.out.println(modelo);
		}
		
		em.close();
		
	}

}
