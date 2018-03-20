package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaFabricantes {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntitymanager();
		
		List<Fabricante> fabricantes = em.createQuery("select f from Fabricante f", Fabricante.class).getResultList();
		
		for (Fabricante fabricante : fabricantes) {
			System.out.println(fabricante.getNome());
		}
		
		
		//-------------------------------------
		List<String> fabricantes1 = em.createQuery("select f.nome from Fabricante f", String.class).getResultList();
		
		for (String fabricante : fabricantes1) {
			System.out.println("nome: " +fabricante);
		}
		
		//-------------------------------------
		
		
		em.close();
		
	}

}
