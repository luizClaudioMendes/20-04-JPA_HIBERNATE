package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaDescricaoECategoriaDeModeloCarro {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntitymanager();
		
		
		
		List<Object[]> resultado = em.createQuery("SELECT mc.descricao, mc.categoria FROM ModeloCarro mc").getResultList();
		
		for (Object[] obj : resultado) {
			System.out.println("Descricao: "+ obj[0] + ". E Categoria: "+ obj[1]);
		}
		
		em.close();
		
	}

}
