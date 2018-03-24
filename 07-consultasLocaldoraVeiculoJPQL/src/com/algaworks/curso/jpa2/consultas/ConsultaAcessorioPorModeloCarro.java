package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaAcessorioPorModeloCarro {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntitymanager();
		
		StringBuilder sb = new StringBuilder(0);
		sb.append(" SELECT a.descricao ");
		sb.append(" FROM Carro c");
		sb.append(" JOIN c.acessorios a"); //linha do join
		sb.append(" WHERE c.modelo.descricao = 'Cruze'");
		
		
		List<String> resultado = em.createQuery(sb.toString(), String.class).getResultList();
		
		for (String acessorio : resultado) {
			System.out.println(acessorio);
		}
		
		em.close();
		
	}

}
