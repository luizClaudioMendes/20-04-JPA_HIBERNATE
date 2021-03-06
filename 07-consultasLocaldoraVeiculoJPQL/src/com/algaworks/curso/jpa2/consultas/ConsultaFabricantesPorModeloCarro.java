package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaFabricantesPorModeloCarro {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntitymanager();
		
		List<String> nomeFabricantes = em.createQuery("select mc.fabricante.nome from ModeloCarro mc", String.class).getResultList();
		
		for (String nomeFabricante : nomeFabricantes) {
			System.out.println("nome: " + nomeFabricante);
		}
		
		em.close();
		
	}

}
